package com.hbcu.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public interface IDynamoFactory {

    DynamoDBMapper buildMapper();

    DynamoDB buildDynamo();
}
