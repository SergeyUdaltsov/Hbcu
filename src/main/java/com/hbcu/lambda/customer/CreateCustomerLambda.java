package com.hbcu.lambda.customer;

import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.hbcu.dagger.DaggerLambdaComponent;
import com.hbcu.lambda.AbstractLambdaHandler;
import com.hbcu.model.Customer;
import com.hbcu.model.request.CustomerRequest;
import com.hbcu.service.ICustomerService;

import javax.inject.Inject;

public class CreateCustomerLambda extends AbstractLambdaHandler<CustomerRequest, Object> implements RequestStreamHandler {
    private ICustomerService customerService;

    public CreateCustomerLambda() {
        super(CustomerRequest.class);
        DaggerLambdaComponent.create().inject(this);
    }

    protected Object process(CustomerRequest request) {
        Customer customer = new Customer();
        customer.setCompanyName(request.getCompanyName());
        customer.setId(request.getId());
        customer.setEmail(request.getEmail());
        customer.setContacts(request.getContacts());
        customer.setDescription(request.getDescription());
        this.customerService.save(customer);
        return "Customer with email " + request.getEmail() + " successfully.";
    }

    @Inject
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public ICustomerService getCustomerService() {
        return this.customerService;
    }
}