package com.hbcu.dagger;

import com.hbcu.lambda.CreateCustomerLambda;
import com.hbcu.lambda.ListCustomersLambda;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {DaggerDaoProvider.class, DaggerServiceProvider.class})
public interface LambdaComponent {

    void inject(ListCustomersLambda lambda);
    void inject(CreateCustomerLambda lambda);
}
