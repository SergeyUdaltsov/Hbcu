package com.hbcu.dao.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.document.*;
import com.hbcu.dao.IBaseDao;
import com.hbcu.dao.IDynamoFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseDao<ENTITY> implements IBaseDao<ENTITY> {
    private IDynamoFactory dynamoFactory;
    private String tableName;
    private Class<ENTITY> entityClass;
    private DynamoDBMapper dynamoDBMapper;
    private DynamoDB dynamoDB;

    public BaseDao() {
    }

    public BaseDao(IDynamoFactory dynamoFactory, Class<ENTITY> entityClass) {
        this.dynamoFactory = dynamoFactory;
        this.entityClass = entityClass;
        DynamoDBTable annotation = (DynamoDBTable) entityClass.getAnnotation(DynamoDBTable.class);
        if (annotation == null) {
            throw new RuntimeException("@DynamoDbTable name cannot be null.");
        } else {
            String tableName = annotation.tableName();
            if (tableName.equals("")) {
                throw new RuntimeException("Table name should not be null.");
            } else {
                this.tableName = tableName;
            }
        }
    }

    @Override
    public List<Item> getItemsByIndex(String indexName, String hashKeyName, String hashKeyValue) {
        Table table = getDynamoDB().getTable(tableName);
        Index index = table.getIndex(indexName);
        ItemCollection<QueryOutcome> results = index.query(hashKeyName, hashKeyValue);
        Iterator<Item> iterator = results.iterator();
        List<Item> resultItems = new ArrayList<>();
        while (iterator.hasNext()) {
            resultItems.add(iterator.next());
        }
        return resultItems;
    }

    public void save(ENTITY item, DynamoDBMapperConfig config) {
        getMapper().save(item, config);
    }

    public void save(ENTITY item) {
        getMapper().save(item);
    }

    public List<ENTITY> getAllEntities() {
        return getMapper().scan(this.entityClass, new DynamoDBScanExpression());
    }

    public ENTITY getEntityByPrimaryKey(PrimaryKey key) {
        return null;
    }

    public ENTITY getEntityByQueryObject(ENTITY object) {
        return getMapper().load(object);
    }

    public DynamoDBMapper getMapper() {
        if (dynamoDBMapper == null) {
            dynamoDBMapper = dynamoFactory.buildMapper();
        }
        return dynamoDBMapper;
    }

    public DynamoDB getDynamoDB() {
        if (dynamoDB == null) {
            dynamoDB = dynamoFactory.buildDynamo();
        }
        return dynamoDB;
    }
}
