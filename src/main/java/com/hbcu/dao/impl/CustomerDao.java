package com.hbcu.dao.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.hbcu.dao.ICustomerDao;
import com.hbcu.model.Customer;

import java.util.List;

public class CustomerDao extends BaseDao<Customer> implements ICustomerDao {
    public CustomerDao(DynamoDBMapper mapper) {
        super(mapper, Customer.class);
    }

    public void save(Customer customer) {
        super.save(customer, DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES.config());
    }

    public List<Customer> getAllCustomers() {
        return super.getAllEntities();
    }

    public Customer getCustomerById(int id) {
        Customer customer = new Customer();
        customer.setId(id);
        return (Customer)super.getEntityByQueryObject(customer);
    }
}