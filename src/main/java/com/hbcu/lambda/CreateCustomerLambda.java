package com.hbcu.lambda;

import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.hbcu.dagger.DaggerLambdaComponent;
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

    @Override
    protected Object process(CustomerRequest request) {
        Customer customer = new Customer();
        customer.setCompanyName(request.getCompanyName());
        customer.setEmail(request.getEmail());
        customer.setArea(request.getArea());
        customer.setContacts(request.getContacts());
        customer.setContractExpiration(request.getContractExpiration());
        customer.setRent(request.getRent());
        customer.setRoom(request.getRoom());
        customer.setDescription(request.getDescription());
        customerService.save(customer);
        return "Customer with email " + request.getEmail() + " successfully.";
    }

    @Inject
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }




    public ICustomerService getCustomerService() {
        return customerService;
    }
}
