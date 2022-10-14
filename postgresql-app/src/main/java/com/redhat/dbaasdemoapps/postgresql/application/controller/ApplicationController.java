package com.redhat.dbaasdemoapps.postgresql.application.controller;


import com.redhat.dbaasdemoapps.postgresql.application.entity.Fruit;
import com.redhat.dbaasdemoapps.postgresql.application.exception.ResourceNotFoundException;
import com.redhat.dbaasdemoapps.postgresql.application.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @Autowired
    FruitRepository fruitRepository;

    @GetMapping(value = "/fruits")
    public List<Fruit> getFruits() {
        return fruitRepository.findAll();
    }

    @GetMapping(value = "/fruits/{id}")
    public Fruit getFruit(@PathVariable String id) {
        return fruitRepository.findById(id).orElse(null);
    }

    @PostMapping(value = "/fruits")
    public Fruit createFruit(@RequestBody Fruit theFruit) {
        UUID id = UUID.randomUUID();
        theFruit.setId(id.toString());
        return fruitRepository.save(theFruit);
    }

    @PutMapping(value = "/fruits/{id}")
    public Fruit updateFruit(@RequestBody Fruit theFruit, @PathVariable String id) throws IllegalArgumentException {
        Fruit cur = fruitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fruit not found."));
        cur.setQuantity(theFruit.getQuantity());
        cur.setName(theFruit.getName());
        return fruitRepository.save(cur);
    }

    @DeleteMapping(value = "/fruits/{id}")
    public void deleteFruit(@PathVariable String id) {
        fruitRepository.deleteById(id);
    }
}
