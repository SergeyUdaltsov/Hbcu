package com.hbcu.service.impl;

import com.hbcu.dao.ICustomerDao;
import com.hbcu.model.Customer;
import com.hbcu.model.contract.Contract;
import com.hbcu.model.contract.Payment;
import com.hbcu.model.contract.serviceBalance.ServiceBalance;
import com.hbcu.service.ICustomerService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService implements ICustomerService {
    private ICustomerDao dao;

    public CustomerService(ICustomerDao dao) {
        this.dao = dao;
    }

    public void save(Customer customer) {
        this.dao.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return this.dao.getAllCustomers();
    }

    public Customer getCustomerById(int id) {
        Customer customer = this.dao.getCustomerById(id);
        fillBalances(customer.getContracts());
        return customer;
    }

    private void fillBalances(List<Contract> contracts ) {
        for (Contract contract : contracts) {
            List<ServiceBalance> serviceBalances = contract.getServiceBalances();
            for (ServiceBalance balance : serviceBalances) {
                fillSelectedBalance(balance);
            }
        }
    }

    private void fillSelectedBalance(ServiceBalance balance) {
        double start = balance.getBalance();
        List<Payment> sortedPayments = balance.getPayments().stream()
                .sorted(Comparator.comparingDouble(Payment::getDate))
                .collect(Collectors.toList());
        for (Payment payment : sortedPayments) {
            start = start - payment.getSumBill() + payment.getSumPayment();
            payment.setBalance(start);
        }


    }
}
