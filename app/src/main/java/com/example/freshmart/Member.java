package com.example.freshmart;

import android.content.Intent;

public class Member {

    private String name,email,address;
    private Long contactno;

    public Member() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContactNo() {
        return contactno;
    }

    public void setContactNo(Long contactno) {
        this.contactno = contactno;
    }
}
