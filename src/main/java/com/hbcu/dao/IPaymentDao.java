package com.hbcu.dao;

import com.hbcu.model.contract.Payment;

import java.util.List;

public interface IPaymentDao {

    void save(Payment payment);

    List<Payment> getPaymentsByContractName(String contractName);
}
