package com.hbcu.dagger;

import com.hbcu.dao.ICustomerDao;
import com.hbcu.service.impl.CustomerService;
import com.hbcu.service.ICustomerService;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(includes = DaggerDaoProvider.class)
public class DaggerServiceProvider {

    @Provides
    @Singleton
    public ICustomerService customerService(ICustomerDao customerDao) {
        return new CustomerService(customerDao);
    }
}
