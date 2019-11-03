package com.hbcu.dagger;

import com.hbcu.lambda.contract.SignContractLambda;
import com.hbcu.lambda.customer.CreateCustomerLambda;
import com.hbcu.lambda.customer.ListCustomersLambda;
import com.hbcu.lambda.payment.ProvideBillLambda;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(
        modules = {DaggerDaoProvider.class,
                DaggerServiceProvider.class}
)
public interface LambdaComponent {
    void inject(ListCustomersLambda lambda);

    void inject(CreateCustomerLambda lambda);

    void inject(SignContractLambda lambda);

    void inject(ProvideBillLambda lambda);
}

