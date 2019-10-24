package com.hbcu.dao;

import com.hbcu.model.Customer;

import java.util.List;

public interface ICustomerDao {
    void save(Customer var1);

    List<Customer> getAllCustomers();

    Customer getCustomerById(int var1);
}
