package com.hbcu.dao.impl;

import com.hbcu.dao.IDynamoFactory;
import com.hbcu.dao.IPaymentDao;
import com.hbcu.model.contract.Payment;

import java.util.List;

public class PaymentDao extends BaseDao<Payment> implements IPaymentDao {

    public static final String PAYMENT_INDEX_NAME = "cn-index";
    public static final String PAYMENT_INDEX_HASH_KEY = "cn";

    public PaymentDao(IDynamoFactory dynamoFactory) {
        super(dynamoFactory, Payment.class);
    }

    @Override
    public void save(Payment payment) {
        super.save(payment);
    }

    @Override
    public List<Payment> getPaymentsByContractName(String contractName) {

        return super.getItemsByIndex(PAYMENT_INDEX_NAME, PAYMENT_INDEX_HASH_KEY, contractName);
    }
}
