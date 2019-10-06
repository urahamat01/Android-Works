package com.rahamat.convertrecycleview;

public class Contact {
    private String name;
    private String phoneNo;
    private int photo;

    public Contact() {
    }

    public Contact(String name, String phoneNo, int photo) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public int getPhoto() {
        return photo;
    }
}
