package com.mdrahamat.firbasedata;

public class User {
    private String name;
    private String email;
    private String age;
    private String bloadGroup;

    public User() {

        //constracter
    }

    public User(String name, String email, String age, String bloadGroup) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.bloadGroup = bloadGroup;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBloadGroup() {
        return bloadGroup;
    }

    public void setBloadGroup(String bloadGroup) {
        this.bloadGroup = bloadGroup;
    }
}
