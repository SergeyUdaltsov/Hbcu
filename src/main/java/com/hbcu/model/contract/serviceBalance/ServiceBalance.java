package com.hbcu.model.contract.serviceBalance;

import com.hbcu.model.contract.Payment;

import java.math.BigDecimal;
import java.util.List;

public class ServiceBalance {

    private String contractName;
    private List<Payment> rentPayments;
    private List<Payment> powPayments;
    private List<Payment> expPayments;

    private BigDecimal rentBalance;
    private BigDecimal powBalance;
    private BigDecimal expBalance;

    public ServiceBalance() {
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public List<Payment> getRentPayments() {
        return rentPayments;
    }

    public void setRentPayments(List<Payment> rentPayments) {
        this.rentPayments = rentPayments;
    }

    public List<Payment> getPowPayments() {
        return powPayments;
    }

    public void setPowPayments(List<Payment> powPayments) {
        this.powPayments = powPayments;
    }

    public List<Payment> getExpPayments() {
        return expPayments;
    }

    public void setExpPayments(List<Payment> expPayments) {
        this.expPayments = expPayments;
    }

    public BigDecimal getRentBalance() {
        return rentBalance;
    }

    public void setRentBalance(BigDecimal rentBalance) {
        this.rentBalance = rentBalance;
    }

    public BigDecimal getPowBalance() {
        return powBalance;
    }

    public void setPowBalance(BigDecimal powBalance) {
        this.powBalance = powBalance;
    }

    public BigDecimal getExpBalance() {
        return expBalance;
    }

    public void setExpBalance(BigDecimal expBalance) {
        this.expBalance = expBalance;
    }
}
