package com.redhat.dbaasdemoapps.postgresql.application.repository;

import com.redhat.dbaasdemoapps.postgresql.application.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, String> {
    List<Fruit> findAll();

    Optional<Fruit> findById(String id);

    void deleteById(String id);
}
