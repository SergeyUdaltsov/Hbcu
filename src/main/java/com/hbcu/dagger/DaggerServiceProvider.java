package com.hbcu.dagger;

import com.hbcu.dao.ICustomerDao;
import com.hbcu.dao.IPaymentDao;
import com.hbcu.service.IPaymentService;
import com.hbcu.service.impl.CustomerService;
import com.hbcu.service.ICustomerService;
import com.hbcu.service.impl.PaymentService;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(includes = {DaggerDaoProvider.class})
public class DaggerServiceProvider {

    public DaggerServiceProvider() {
    }

    @Provides
    @Singleton
    public ICustomerService customerService(ICustomerDao customerDao, IPaymentService paymentService) {
        return new CustomerService(customerDao, paymentService);
    }

    @Provides
    @Singleton
    public IPaymentService paymentService(IPaymentDao paymentDao) {
        return new PaymentService(paymentDao);
    }
}