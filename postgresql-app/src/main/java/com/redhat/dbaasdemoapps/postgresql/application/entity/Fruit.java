package com.redhat.dbaasdemoapps.postgresql.application.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fruit")
public class Fruit implements Serializable {

    @Id
    String id;
    String name;
    String quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
