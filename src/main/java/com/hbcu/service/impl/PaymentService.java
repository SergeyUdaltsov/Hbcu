package com.hbcu.service.impl;

import com.hbcu.dao.IPaymentDao;
import com.hbcu.model.contract.Payment;
import com.hbcu.model.contract.PaymentType;
import com.hbcu.model.contract.ServiceType;
import com.hbcu.service.IPaymentService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PaymentService implements IPaymentService {

    private IPaymentDao paymentDao;

    public PaymentService(IPaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public void save(Payment payment) {
        paymentDao.save(payment);
    }


}
