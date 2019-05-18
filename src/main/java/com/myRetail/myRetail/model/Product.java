package com.myRetail.myRetail.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {


    @Id
    private long id;

    private String name;

    @Embedded
    private CurrentPrice current_price;

    public Product() {
    }

    public Product(long id, String name, CurrentPrice current_price) {
        this.id = id;
        this.name = name;
        this.current_price = current_price;
    }

    public Product(String name, CurrentPrice current_price) {
        this.name = name;
        this.current_price = current_price;
    }

    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrentPrice getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(CurrentPrice current_price) {
        this.current_price = current_price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", current_price=" + current_price +
                '}';
    }
}
