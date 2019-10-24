package com.hbcu.service;

import com.hbcu.model.Customer;

import java.util.List;

public interface ICustomerService {
    void save(Customer var1);

    List<Customer> getAllCustomers();

    Customer getCustomerById(int var1);
}
