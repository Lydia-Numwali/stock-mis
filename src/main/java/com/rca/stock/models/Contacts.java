package com.rca.stock.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Contacts {
    private String email;
    private String phone;

    public Contacts(){
    }

    public Contacts(String email, String phone){
        super();
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
