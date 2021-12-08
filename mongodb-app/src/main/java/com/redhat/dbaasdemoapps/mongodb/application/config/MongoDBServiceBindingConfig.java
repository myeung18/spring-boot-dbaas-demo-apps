package com.redhat.dbaasdemoapps.mongodb.application.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.cloud.bindings.Binding;
import org.springframework.cloud.bindings.Bindings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class MongoDBServiceBindingConfig {

    //    @Bean
    public MongoClient mongo() throws Exception {
//        final ConnectionString connectionString = new ConnectionString("mongodb://myuser:mypassword@172.17.0.3:27017/fruits?authSource=admin");
        final ConnectionString connectionString = new ConnectionString("mongodb+srv://myuser:mypassword@cluster0.qhhuv.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean(name = "ServiceBindingMongoClient")
    public MongoClient createMongoClient() {
        List<Binding> bindings = new Bindings().filterBindings("mongodb");
        Map<String, String> binding = bindings.get(0).getSecret();
        String un = binding.get("username");
        String pwd = binding.get("password");
        String dbName = binding.get("database");
        String host = binding.get("host");
        String srv = binding.get("srv");
        String options = binding.get("options");
        StringBuilder sb = new StringBuilder("mongodb://");
        if ("true".equals(srv)) {
            sb.setLength(0);
            sb.append("mongodb+srv://");
        }

        sb.append(un).append(":").append(pwd).append("@").append(host).append("/").append(dbName);
        if (options != null || !"".equals(options)) {
            sb.append("?").append(options);
        }

        final ConnectionString connectionString = new ConnectionString(sb.toString());
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        return MongoClients.create(mongoClientSettings);
    }
}