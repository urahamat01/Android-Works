package com.beskilled.recyclearview;

public class Student {
    private String name;
    private int id;
    private String phone;
    private String email;
    private int profileImage;

    public Student(String name, int id, String phone, String email, int profileImage) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getProfileImage() {
        return profileImage;
    }
}




