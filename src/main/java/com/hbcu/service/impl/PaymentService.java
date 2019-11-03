package com.hbcu.service.impl;

import com.hbcu.dao.IPaymentDao;
import com.hbcu.model.contract.Payment;
import com.hbcu.service.IPaymentService;

import java.util.List;

public class PaymentService implements IPaymentService {

    private IPaymentDao paymentDao;

    public PaymentService(IPaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public void createPayment(Payment payment) {
        paymentDao.save(payment);
    }

    @Override
    public List<Payment> getPaymentsByContract(String contractName) {
        return paymentDao.getPaymentsByContractName(contractName);
    }
}
