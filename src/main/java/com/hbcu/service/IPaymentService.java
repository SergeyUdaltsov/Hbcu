package com.hbcu.service;

import com.hbcu.model.contract.Payment;

import java.util.List;

public interface IPaymentService {

    void createPayment(Payment payment);

    List<Payment> getPaymentsByContract(String contractName);
}
