package com.hbcu.service.impl;

import com.hbcu.dao.ICustomerDao;
import com.hbcu.model.Customer;
import com.hbcu.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerDao dao;

    public CustomerService(ICustomerDao dao) {
        this.dao = dao;
    }

    public void save(Customer customer) {
        dao.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return null;
    }


}
