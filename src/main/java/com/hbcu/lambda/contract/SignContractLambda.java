package com.hbcu.lambda.contract;

import com.hbcu.dagger.DaggerLambdaComponent;
import com.hbcu.lambda.AbstractLambdaHandler;
import com.hbcu.model.Customer;
import com.hbcu.model.contract.Contract;
import com.hbcu.model.request.SignContractRequest;
import com.hbcu.service.ICustomerService;
import com.hbcu.utils.JsonUtils;

import javax.inject.Inject;
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
        System.out.println("Contract from request: " + JsonUtils.convertObjectToJson(contract));
        if (!contractValid(customer, contract)) {
            return "Contract data is not valid or contract alreadt exists";
        }
        List<Contract> contracts = customer.getContracts();
        contracts.add(contract);
        System.out.println("Customer to be saved to db: " + JsonUtils.convertObjectToJson(customer));
        this.customerService.save(customer);
        return "Contract successfully saved.";


    }

    public ICustomerService getCustomerService() {
        return this.customerService;
    }

    private boolean contractValid(Customer customer, Contract contract) {
        List<Contract> contracts = customer.getContracts();
        if (contracts.isEmpty()) {
            return true;
        }
        for (Contract contr : contracts) {
            if (contract.getContractName().equalsIgnoreCase(contr.getContractName())) {
                return false;
            }
        }
        return true;
    }

    @Inject
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }
}