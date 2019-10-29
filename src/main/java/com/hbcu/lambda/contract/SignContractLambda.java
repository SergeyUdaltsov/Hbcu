package com.hbcu.lambda.contract;

import com.hbcu.dagger.DaggerLambdaComponent;
import com.hbcu.lambda.AbstractLambdaHandler;
import com.hbcu.model.contract.Contract;
import com.hbcu.model.Customer;
import com.hbcu.model.request.SignContractRequest;
import com.hbcu.service.ICustomerService;
import com.hbcu.utils.JsonUtils;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

public class SignContractLambda extends AbstractLambdaHandler<SignContractRequest, Object> {
    private ICustomerService customerService;

    public SignContractLambda() {
        super(SignContractRequest.class);
        DaggerLambdaComponent.create().inject(this);
    }

    protected Object process(SignContractRequest request) {
        int customerId = request.getCustomerId();
        Contract contract = request.getContract();
        Customer customer = this.customerService.getCustomerById(customerId);
        System.out.println("Customer from db: " + JsonUtils.convertObjectToJson(customer));
        List<Contract> contracts = customer.getContracts();
        Iterator var6 = contracts.iterator();

        Contract contr;
        do {
            if (!var6.hasNext()) {
                contracts.add(contract);
                System.out.println("Customer to be saved to db: " + JsonUtils.convertObjectToJson(customer));
                this.customerService.save(customer);
                return "Contract successfully saved.";
            }

            contr = (Contract)var6.next();
        } while(!contract.getContractName().equalsIgnoreCase(contr.getContractName()));

        throw new RuntimeException(String.format("Contract with number %s is already exists.", contr.getContractName()));
    }

    public ICustomerService getCustomerService() {
        return this.customerService;
    }

    @Inject
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }
}