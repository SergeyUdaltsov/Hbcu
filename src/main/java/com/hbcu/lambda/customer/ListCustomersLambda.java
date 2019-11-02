package com.hbcu.lambda.customer;

import com.hbcu.dagger.DaggerLambdaComponent;
import com.hbcu.lambda.AbstractLambdaHandler;
import com.hbcu.model.Customer;
import com.hbcu.model.contract.Contract;
import com.hbcu.model.contract.Payment;
import com.hbcu.model.contract.ServiceType;
import com.hbcu.model.contract.serviceBalance.ContractBalance;
import com.hbcu.model.contract.serviceBalance.TableBalance;
import com.hbcu.model.dto.CustomerDto;
import com.hbcu.model.request.CustomerRequest;
import com.hbcu.service.ICustomerService;
import com.hbcu.service.IPaymentService;
import com.hbcu.utils.JsonUtils;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListCustomersLambda extends AbstractLambdaHandler<CustomerRequest, Object> {
    private ICustomerService customerService;
    private IPaymentService paymentService;

    public ListCustomersLambda() {
        super(CustomerRequest.class);
        DaggerLambdaComponent.create().inject(this);
    }

    protected Object process(CustomerRequest request) {
        int id = request.getId();
        if (id == 0) {
            return customerService.getAllCustomers();
        }
        Customer customer = customerService.getCustomerById(id);
        CustomerDto customerDto = createCustomerDto(customer);
        System.out.println("CustomerDTO --------- " + JsonUtils.convertObjectToJson(customerDto, false));
        return customerDto;
    }

    private CustomerDto createCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        List<Contract> contracts = customer.getContracts();
        List<ContractBalance> contractBalances = new ArrayList<>();
        for (Contract contract : contracts) {
            String contractName = contract.getContractName();
            ContractBalance balance = createContractBalance(contractName);
            contractBalances.add(balance);
        }
        customerDto.setBalances(contractBalances);
        customerDto.setCustomer(customer);
        return customerDto;
    }

    private ContractBalance createContractBalance(String contractName) {
        List<Payment> payments = paymentService.getPaymentsByContract(contractName);
        ContractBalance contractBalance = new ContractBalance();
        contractBalance.setContractName(contractName);
        List<TableBalance> tableBalances = contractBalance.getTableBalances();
        for (ServiceType type : ServiceType.values()) {
            TableBalance tableBalance = new TableBalance();
            tableBalance.setServiceType(type);
            List<Payment> paymentsByType = payments.stream()
                    .filter(p -> type == p.getServiceType())
                    .sorted(Comparator.comparingLong(Payment::getDate).reversed())
                    .collect(Collectors.toList());
            tableBalance.setBalance(fillPaymentsWithBalances(paymentsByType));
            tableBalance.setPayments(paymentsByType);
            tableBalances.add(tableBalance);
        }
        return contractBalance;
    }

    private BigDecimal fillPaymentsWithBalances(List<Payment> sortedPayments) {

        BigDecimal start = BigDecimal.ZERO;
        for (Payment payment : sortedPayments) {
            start = start.subtract(payment.getSumBill()).add(payment.getSumPayment());
            payment.setBalance(start);
        }
        return start;
    }

    @Inject
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @Inject
    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Test
    public void testMethod() {

    }
}
