package com.hbcu.dao.dynamo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.hbcu.dao.IDynamoFactory;

public class DynamoDbFactory implements IDynamoFactory {

    private AmazonDynamoDB dynamoDB;

    public DynamoDbFactory(AmazonDynamoDB dynamoDB) {
        this.dynamoDB = dynamoDB;
    }

    @Override
    public DynamoDBMapper buildMapper() {
        return new DynamoDBMapper(dynamoDB);
    }

    @Override
    public DynamoDB buildDynamo() {
        return new DynamoDB(dynamoDB);
    }
}
