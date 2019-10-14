package com.hbcu.lambda;

import com.hbcu.dagger.DaggerLambdaComponent;
import com.hbcu.model.request.CustomerRequest;
import com.hbcu.service.ICustomerService;

import javax.inject.Inject;

public class ListCustomersLambda extends AbstractLambdaHandler<CustomerRequest, Object> {

    private ICustomerService customerService;

    public ListCustomersLambda() {
        super(CustomerRequest.class);
        DaggerLambdaComponent.create().inject(this);
    }

    protected Object process(CustomerRequest request) {

        return null;
    }

    public ICustomerService getCustomerService() {
        return customerService;
    }

    @Inject
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }
}
