package com.redhat.dbaasdemoapps.mongodb.application.repository;

import com.redhat.dbaasdemoapps.mongodb.application.model.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FruitRepository extends MongoRepository<Fruit, String> {
    List<Fruit> findAll();

    Optional<Fruit> findById(String id);

    void deleteById(String id);
}
