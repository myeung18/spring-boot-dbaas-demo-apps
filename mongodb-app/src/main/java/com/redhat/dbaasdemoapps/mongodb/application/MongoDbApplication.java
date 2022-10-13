package com.redhat.dbaasdemoapps.mongodb.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDbApplication {
    public static void main(String[] args) {
        String property = "org.springframework.cloud.bindings.boot.enable";

        String val = System.getProperty(property);
        System.out.println("isOk " + val);
        System.getProperties().setProperty(property, "true");
        SpringApplication.run(MongoDbApplication.class, args);
    }
}
