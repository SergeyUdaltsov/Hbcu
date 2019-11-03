package com.hbcu.lambda.customer;

import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.hbcu.dagger.DaggerLambdaComponent;
import com.hbcu.lambda.AbstractLambdaHandler;
import com.hbcu.model.Customer;
import com.hbcu.model.contract.Contract;
import com.hbcu.model.contract.Payment;
import com.hbcu.model.contract.PaymentType;
import com.hbcu.model.contract.ServiceType;
import com.hbcu.model.request.CustomerRequest;
import com.hbcu.service.ICustomerService;
import com.hbcu.service.IPaymentService;
import com.hbcu.utils.JsonUtils;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CreateCustomerLambda extends AbstractLambdaHandler<CustomerRequest, Object> implements RequestStreamHandler {
    private ICustomerService customerService;
    private IPaymentService paymentService;

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

    @Inject
    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public ICustomerService getCustomerService() {
        return this.customerService;
    }

    @Test
    public void testMethod1() {
        Payment payment = Payment.paymentBuilder()
                .withContractNumber("contrFromPaymentService")
                .withServiceType(ServiceType.EXPLOATATION)
                .withPaymentType(PaymentType.BILL)
                .withDate(152119997599L)
                .withSumBill(BigDecimal.valueOf(162354))
                .withSumPayment(BigDecimal.ZERO)
                .build();
        paymentService.createPayment(payment);
    }

    @Test
    public void testMethod3() {
        List<Payment> payments = paymentService.getPaymentsByContract("contrFromPaymentService");
        for (Object payment : payments) {
            System.out.println("Payment---- " + JsonUtils.convertObjectToJson(payment, false));
        }
    }

    @Test
    public void testMethod() {

        Contract contract = Contract.contractBuilder()
                .withArea(BigDecimal.valueOf(62656.32))
                .withFinDate(15626656595L)
                .withStartDate(15626656595L)
                .withName("dhfbiefiyf/558")
                .withRent(BigDecimal.valueOf(265.3))
                .withRoom("room")
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