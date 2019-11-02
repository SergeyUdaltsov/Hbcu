package com.hbcu.model.contract.serviceBalance;

import java.util.ArrayList;
import java.util.List;

public class ContractBalance {

    private String contractName;
    private List<TableBalance> tableBalances;

    public ContractBalance() {
        this.tableBalances = new ArrayList<>();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public List<TableBalance> getTableBalances() {
        return tableBalances;
    }

    public void setTableBalances(List<TableBalance> tableBalances) {
        this.tableBalances = tableBalances;
    }
}
