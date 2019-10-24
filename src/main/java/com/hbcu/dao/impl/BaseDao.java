package com.hbcu.dao.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
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
        DynamoDBTable annotation = (DynamoDBTable)entityClass.getAnnotation(DynamoDBTable.class);
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

    public void save(ENTITY item, DynamoDBMapperConfig config) {
        this.dynamoDBMapper.save(item, config);
    }

    public List<ENTITY> getAllEntities() {
        return this.dynamoDBMapper.scan(this.entityClass, new DynamoDBScanExpression());
    }

    public ENTITY getEntityByPrimaryKey(PrimaryKey key) {
        return null;
    }

    public ENTITY getEntityByQueryObject(ENTITY object) {
        return this.dynamoDBMapper.load(object);
    }
}
