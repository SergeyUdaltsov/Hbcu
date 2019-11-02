package com.hbcu.dagger;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.hbcu.dao.ICustomerDao;
import com.hbcu.dao.IDynamoFactory;
import com.hbcu.dao.IPaymentDao;
import com.hbcu.dao.dynamo.DynamoDbFactory;
import com.hbcu.dao.impl.CustomerDao;
import com.hbcu.dao.impl.PaymentDao;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DaggerDaoProvider {

    @Provides
    @Singleton
    public ICustomerDao customerDao(IDynamoFactory dynamoFactory) {
        return new CustomerDao(dynamoFactory);
    }

    @Provides
    @Singleton
    public IPaymentDao paymentDao(IDynamoFactory dynamoFactory) {
        return new PaymentDao(dynamoFactory);
    }

    @Provides
    @Singleton
    public DynamoDBMapper dynamoDBMapper() {
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
        return new DynamoDBMapper(amazonDynamoDB);
    }

    @Provides
    @Singleton
    public IDynamoFactory dynamoFactory() {
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
        return new DynamoDbFactory(amazonDynamoDB);
    }


}
