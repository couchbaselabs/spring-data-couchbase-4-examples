package com.example.sp3;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.query.ViewIndexed;

@Configuration
public class Config extends AbstractCouchbaseConfiguration {


    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "Administrator";
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getBucketName() {
        return "default";
    }


    /**
     * OPTIONAL: In this example we are using annotations to
     */

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
