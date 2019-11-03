package com.hbcu.model;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.hbcu.model.contract.Contract;
import com.hbcu.model.contract.Payment;
import com.hbcu.model.contract.PaymentType;
import com.hbcu.model.contract.ServiceType;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

public class EntityConverter<ENTITY> {

    public static final Function<Customer, Contract> CONVERT_ITEM_TO_CONTRCT = (item) -> {

        List<Contract> contracts = item.getContracts();
        return contracts.get(0);
    };

    public static final Function<Item, Payment> ITEM_TO_PAYMENT = (item) -> {
        return Payment.paymentBuilder()
                .withSumPayment((BigDecimal) item.get("sumPay"))
                .withSumBill((BigDecimal) item.get("sumBill"))
                .withDate(((BigDecimal)item.get("d")).longValue())
                .withPaymentType(PaymentType.valueOf((String) item.get("pt")))
                .withContractNumber((String) item.get("cn"))
                .withServiceType(ServiceType.valueOf((String) item.get("st")))
                .withId((String) item.get("id"))
                .build();
    };
}
