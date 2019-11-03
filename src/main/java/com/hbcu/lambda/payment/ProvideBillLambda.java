package com.hbcu.lambda.payment;

import com.hbcu.dagger.DaggerLambdaComponent;
import com.hbcu.lambda.AbstractLambdaHandler;
import com.hbcu.model.Customer;
import com.hbcu.model.contract.Contract;
import com.hbcu.model.contract.Payment;
import com.hbcu.model.contract.PaymentType;
import com.hbcu.model.contract.ServiceType;
import com.hbcu.service.ICustomerService;
import com.hbcu.service.IPaymentService;
import com.hbcu.utils.DateUtils;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProvideBillLambda extends AbstractLambdaHandler<Object, Object> {

    private IPaymentService paymentService;
    private ICustomerService customerService;

    public ProvideBillLambda() {
        super(Object.class);
        DaggerLambdaComponent.create().inject(this);
    }

    @Override
    protected Object process(Object request) {
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            List<Contract> contracts = customer.getContracts();
            for (Contract contract : contracts) {
                String contractName = contract.getContractName();
                BigDecimal area = contract.getArea();
                BigDecimal rent = contract.getRent();
                BigDecimal sumBill;
                long finDate = contract.getFinDate();
                if (finDate > DateUtils.getEndOfNextMonth()) {
                    sumBill = area.multiply(rent);

                } else {
                    BigDecimal countOfDaysInMonth = BigDecimal.valueOf(DateUtils.getCountOfDaysInMonth(finDate));
                    BigDecimal daysLeft = BigDecimal.valueOf(DateUtils.daysInMonthToEndOfContract(finDate));
                    sumBill = area.multiply(rent).multiply(daysLeft).divide(countOfDaysInMonth, 2, RoundingMode.HALF_UP);
                }
                Payment bill = Payment.paymentBuilder()
                        .withServiceType(ServiceType.RENT)
                        .withContractNumber(contractName)
                        .withPaymentType(PaymentType.BILL)
                        .withDate(DateUtils.getCurrentDate())
                        .withSumBill(sumBill)
                        .build();
                paymentService.createPayment(bill);
            }

        }
        return "Bills were provided successfully.";
    }

    @Test
    public void testMethod() {
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            List<Contract> contracts = customer.getContracts();
            for (Contract contract : contracts) {
                String contractName = contract.getContractName();
                BigDecimal area = contract.getArea();
                BigDecimal rent = contract.getRent();
                BigDecimal sumBill;
                long finDate = contract.getFinDate();
                if (finDate > DateUtils.getEndOfNextMonth()) {
                    sumBill = area.multiply(rent);

                } else {
                    BigDecimal countOfDaysInMonth = BigDecimal.valueOf(DateUtils.getCountOfDaysInMonth(finDate));
                    BigDecimal daysLeft = BigDecimal.valueOf(DateUtils.daysInMonthToEndOfContract(finDate));
                    sumBill = area.multiply(rent).multiply(daysLeft).divide(countOfDaysInMonth, 2, RoundingMode.HALF_UP);
                }
                Payment bill = Payment.paymentBuilder()
                        .withServiceType(ServiceType.RENT)
                        .withContractNumber(contractName)
                        .withPaymentType(PaymentType.BILL)
                        .withDate(DateUtils.getCurrentDate())
                        .withSumBill(sumBill)
                        .build();
                paymentService.createPayment(bill);
            }

        }
    }

    @Inject
    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Inject
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }
}
