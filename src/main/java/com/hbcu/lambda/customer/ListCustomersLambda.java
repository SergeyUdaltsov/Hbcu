package com.hbcu.lambda.customer;

import com.hbcu.dagger.DaggerLambdaComponent;
import com.hbcu.lambda.AbstractLambdaHandler;
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
        int id = request.getId();
        return id == 0 ? this.customerService.getAllCustomers() : this.customerService.getCustomerById(id);
    }

    public ICustomerService getCustomerService() {
        return this.customerService;
    }

    @Inject
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }
}
