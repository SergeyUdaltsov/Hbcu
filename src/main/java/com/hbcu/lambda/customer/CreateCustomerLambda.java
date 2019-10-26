package com.hbcu.lambda.customer;

import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.hbcu.dagger.DaggerLambdaComponent;
import com.hbcu.lambda.AbstractLambdaHandler;
import com.hbcu.model.Customer;
import com.hbcu.model.contract.Contract;
import com.hbcu.model.contract.Payment;
import com.hbcu.model.contract.PaymentType;
import com.hbcu.model.contract.ServiceType;
import com.hbcu.model.contract.serviceBalance.RentBalance;
import com.hbcu.model.contract.serviceBalance.ServiceBalance;
import com.hbcu.model.request.CustomerRequest;
import com.hbcu.service.ICustomerService;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class CreateCustomerLambda extends AbstractLambdaHandler<CustomerRequest, Object> implements RequestStreamHandler {
    private ICustomerService customerService;

    public CreateCustomerLambda() {
        super(CustomerRequest.class);
        DaggerLambdaComponent.create().inject(this);
    }

    protected Object process(CustomerRequest request) {
        Customer customer = new Customer();
        customer.setCompanyName(request.getCompanyName());
        customer.setId(request.getId());
        customer.setEmail(request.getEmail());
        customer.setContacts(request.getContacts());
        customer.setDescription(request.getDescription());
        customerService.save(customer);
        return "Customer with email " + request.getEmail() + " successfully.";
    }

    @Inject
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public ICustomerService getCustomerService() {
        return this.customerService;
    }

    @Test
    public void testMethod() {

        Payment payment = Payment.paymentBuilder()
                .withDate(15264356655L)
                .withPaymentType(PaymentType.REGULAR)
                .withServiceType(ServiceType.RENT)
                .withSumPayment(15265.3)
                .build();
        Payment payment1 = Payment.paymentBuilder()
                .withDate(15264355655L)
                .withServiceType(ServiceType.RENT)
                .withPaymentType(PaymentType.BILL)
                .withSumBill(15643.58)
                .build();
        Payment payment2 = Payment.paymentBuilder()
                .withDate(15264111655L)
                .withPaymentType(PaymentType.DEBTS)
                .withServiceType(ServiceType.RENT)
                .withSumPayment(623.54)
                .build();

        ServiceBalance rentBalance = new RentBalance();
        List<Payment> rentPayments = Arrays.asList(payment, payment1, payment2);
        rentBalance.setPayments(rentPayments);

        Contract contract = Contract.contractBuilder()
                .withArea(62656.32)
                .withFinDate(15626656595L)
                .withStartDate(15626656595L)
                .withNumber("dhfbiefiyf/558")
                .withRent(265.3)
                .withRoom("room")
                .withBalances(Arrays.asList(rentBalance))
                .build();

        Customer customer = Customer.customerBuilder()
                .withCompanyName("Company from builder")
                .withContacts("contacts")
                .withDescription("from new java")
                .withId(653624)
                .withEmail("email")
                .withContracts(Arrays.asList(contract))
                .build();

        customerService.save(customer);
    }
}