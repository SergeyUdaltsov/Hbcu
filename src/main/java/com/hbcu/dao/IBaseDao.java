package com.hbcu.dao;

import com.amazonaws.services.dynamodbv2.document.PrimaryKey;

import java.util.List;

public interface IBaseDao<ENTITY> {
    void save(ENTITY var1);

    List<ENTITY> getAllEntities();

    ENTITY getEntityByPrimaryKey(PrimaryKey var1);

    ENTITY getEntityByQueryObject(ENTITY var1);
}
