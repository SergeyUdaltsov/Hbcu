package com.hbcu.dao.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.hbcu.dao.ICustomerDao;
import com.hbcu.model.Customer;
import org.junit.jupiter.api.Test;

public class CustomerDao extends BaseDao<Customer> implements ICustomerDao {

    public CustomerDao(DynamoDBMapper mapper) {
        super(mapper, Customer.class);
    }

    public void save(Customer customer) {
        super.save(customer, DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES.config());
    }

    @Test
    public void testMethod() {
        Customer customer = new Customer();
        customer.setEmail("ljdvuhu");
        customer.setCompanyName("ekjbfkeb");

        save(customer);
    }
}
