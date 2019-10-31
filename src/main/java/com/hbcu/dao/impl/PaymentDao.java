package com.hbcu.dao.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.hbcu.dao.IPaymentDao;
import com.hbcu.model.contract.Payment;

import java.util.List;

public class PaymentDao extends BaseDao<Payment> implements IPaymentDao {
    public PaymentDao(DynamoDBMapper dynamoDBMapper) {
        super(dynamoDBMapper, Payment.class);
    }

    @Override
    public void save(Payment payment) {
        super.save(payment);
    }

    @Override
    public List<Payment> getPaymentsByContractName(String contractName) {

        return null;
    }
}
