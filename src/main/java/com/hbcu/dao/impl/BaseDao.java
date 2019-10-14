package com.hbcu.dao.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.hbcu.dao.IBaseDao;

import java.util.List;

public abstract class BaseDao<ENTITY> implements IBaseDao<ENTITY> {

    private DynamoDBMapper dynamoDBMapper;
    private String tableName;
    private Class<ENTITY> entityClass;

    public BaseDao() {
    }

    public BaseDao(DynamoDBMapper dynamoDBMapper, Class<ENTITY> entityClass) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.entityClass = entityClass;
        DynamoDBTable annotation = entityClass.getAnnotation(DynamoDBTable.class);
        if (annotation == null) {
            throw new RuntimeException("@DynamoDbTable name cannot be null.");
        }
        String tableName = annotation.tableName();
        if (tableName.equals("")) {
            throw new RuntimeException("Table name should not be null.");
        }
        this.tableName = tableName;
    }

    public void save(ENTITY item, DynamoDBMapperConfig config) {
        dynamoDBMapper.save(item, config);
    }

    public List<ENTITY> getAllEntities() {
        return null;
    }
}
