package com.hbcu.dagger;

import com.hbcu.lambda.contract.SignContractLambda;
import com.hbcu.lambda.customer.CreateCustomerLambda;
import com.hbcu.lambda.customer.ListCustomersLambda;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(
        modules = {DaggerDaoProvider.class,
                DaggerServiceProvider.class}
)
public interface LambdaComponent {
    void inject(ListCustomersLambda var1);

    void inject(CreateCustomerLambda var1);

    void inject(SignContractLambda var1);
}

