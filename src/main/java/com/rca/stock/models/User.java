package com.rca.stock.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Embedded
    private Contacts contacts;

    @OneToMany(mappedBy = "user")
    private List<Reviews> reviews;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    public User(){
    }

    public User(String name, Contacts contacts){
        super();
        this.name = name;
        this.contacts = contacts;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }
}
