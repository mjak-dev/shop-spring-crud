package org.example.session6practice.data.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Product products;

    public Orders() {
    }

    public Orders(Product products) {
        this.products = products;
    }

    public Orders(long id, Product products) {
        this.id = id;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }
}
