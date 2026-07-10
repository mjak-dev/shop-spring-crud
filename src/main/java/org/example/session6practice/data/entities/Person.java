package org.example.session6practice.data.entities;

import jakarta.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "id")
    private BasePersonalInfo basePersonalInfo ;

    @OneToOne
    @JoinColumn(name = "id")
    private Cart cart;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", basePersonalInfo=" + basePersonalInfo +
                ", cart=" + cart +
                '}';
    }
}
