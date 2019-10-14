package com.hbcu.dagger;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.hbcu.dao.ICustomerDao;
import com.hbcu.dao.impl.CustomerDao;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DaggerDaoProvider {

    @Provides
    @Singleton
    public ICustomerDao customerDao(DynamoDBMapper dynamoDBMapper) {
        return new CustomerDao(dynamoDBMapper);
    }

    @Provides
    @Singleton
    public DynamoDBMapper dynamoDBMapper() {
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
        return new DynamoDBMapper(amazonDynamoDB);
    }
}
