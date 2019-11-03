package com.hbcu.dao.impl;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.hbcu.dao.IDynamoFactory;
import com.hbcu.dao.IPaymentDao;
import com.hbcu.model.EntityConverter;
import com.hbcu.model.contract.Payment;

import java.util.List;
import java.util.stream.Collectors;

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

        List<Item> items = super.getItemsByIndex(PAYMENT_INDEX_NAME, PAYMENT_INDEX_HASH_KEY, contractName);

        return items.stream().map(i-> EntityConverter.ITEM_TO_PAYMENT.apply(i)).collect(Collectors.toList());
    }

//    private List<Payment> convertItemsToPayments(List<Item> items) {
//        List<Payment> payments = new ArrayList<>();
//        for (Item item : items) {
//            Object id = item.get("id");
//        }
//    }
}
