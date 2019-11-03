package com.hbcu.dao;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;

import java.util.List;

public interface IBaseDao<ENTITY> {
    void save(ENTITY entity);

    List<ENTITY> getAllEntities();

    ENTITY getEntityByPrimaryKey(PrimaryKey primaryKey);

    ENTITY getEntityByQueryObject(ENTITY object);

    List<Item> getItemsByIndex(String indexName, String hashKeyName, String hashKeyValue);
}
