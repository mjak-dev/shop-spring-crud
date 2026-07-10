package org.example.session6practice.data.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Product> products;

    public Cart() {
    }

    public Cart(long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }
}
