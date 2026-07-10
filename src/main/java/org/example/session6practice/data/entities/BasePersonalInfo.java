package org.example.session6practice.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class BasePersonalInfo {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String family;

    @Column
    private int age;

    @Column(name = "birth_date")
    private Date birthDate;



    public BasePersonalInfo() {
    }

    public BasePersonalInfo(long id, String name, String family, int age, Date birthDate) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.age = age;
        this.birthDate = birthDate;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "BasePersonalInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                '}';
    }
}