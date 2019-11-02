package com.hbcu.model;

import com.hbcu.model.contract.Contract;

import java.util.List;
import java.util.function.Function;

public class EntityConverter<ENTITY> {

    public static final Function<Customer, Contract> CONVERT_ITEM_TO_CONTRCT = (item) -> {

        List<Contract> contracts = item.getContracts();
        return contracts.get(0);
    };
}
