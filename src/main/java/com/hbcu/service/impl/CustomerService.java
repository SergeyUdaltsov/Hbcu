package com.hbcu.service.impl;

import com.hbcu.dao.ICustomerDao;
import com.hbcu.model.Customer;
import com.hbcu.model.contract.Contract;
import com.hbcu.service.ICustomerService;
import com.hbcu.service.IPaymentService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerDao dao;
    private IPaymentService paymentService;

    public CustomerService(ICustomerDao dao, IPaymentService paymentService) {
        this.dao = dao;
        this.paymentService = paymentService;
    }

    public void save(Customer customer) {
        this.dao.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return this.dao.getAllCustomers();
    }

    public Customer getCustomerById(int id) {
        Customer customer = this.dao.getCustomerById(id);
//        System.out.println("customer ------- " + JsonUtils.convertObjectToJson(customer));
        return customer;
    }

//    public CustomerDto getCustomerInfo(int customerId) {
//        Customer customer = this.dao.getCustomerById(customerId);
//
//
//    }

    private void fillBalances(List<Contract> contracts ) {
//        for (Contract contract : contracts) {
//            List<ContractBalance> serviceBalances = Arrays.asList(contract.getExplBalance(),
//                    contract.getPowBalance(), contract.getRentBalance());
//
//            for (ContractBalance balance : serviceBalances) {
//               fillSelectedBalance(balance);
//            }
//        }
    }

//    private void fillSelectedBalance(ContractBalance balance) {
//        if (balance != null) {
//            BigDecimal start = balance.getBalance();
//            List<Payment> sortedPayments = balance.getPayments().stream()
//                    .sorted(Comparator.comparingDouble(Payment::getDate))
//                    .collect(Collectors.toList());
//            for (Payment payment : sortedPayments) {
//                start = start.subtract(payment.getSumBill()).add(payment.getSumPayment());
//                payment.setBalance(start.setScale(2, RoundingMode.HALF_UP));
//            }
//            balance.setPayments(sortedPayments);
////            balance.setBalance(start);
//        }
//    }
}
