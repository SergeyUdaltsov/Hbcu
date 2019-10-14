package com.hbcu.service;

import com.hbcu.model.Customer;

import java.util.List;

public interface ICustomerService {

    void save(Customer customer);

    List<Customer> getAllCustomers();
}
