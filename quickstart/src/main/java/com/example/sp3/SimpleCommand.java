package com.example.sp3;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.manager.query.CreatePrimaryQueryIndexOptions;
import com.couchbase.client.java.manager.query.QueryIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Component;

/**
 * This class is executed once after the application starts
 */
@Component
public class SimpleCommand implements CommandLineRunner {

    @Autowired
    Cluster cluster;

    @Autowired
    CouchbaseTemplate couchbaseTemplate;

    @Autowired
    UserRepository userRepository;;


    @Override
    public void run(String... strings) throws Exception {

        //create primary index if you don't have one
        cluster.queryIndexes().createPrimaryIndex(couchbaseTemplate.getBucketName(),
                CreatePrimaryQueryIndexOptions.createPrimaryQueryIndexOptions().ignoreIfExists(true));

        //Create and save a new user
        User user = new User();
        user.setId("user1");
        user.setName("Alfred");
        user.setDescription("Bruce's butler");
        user.setPosition("butler");
        userRepository.save(user);

        User user2 = new User();
        user2.setId("user2");
        user2.setName("Bruce");
        user2.setDescription("The super rich Bruce Wayne");
        user2.setPosition("super hero");
        userRepository.save(user2);

        //Default repository method to find all Users
        System.out.println("findAll = "+userRepository.findAll());

        //Simple repository method find a user by name
        System.out.println("findByName = "+userRepository.findByName("Bruce"));
    }
}


