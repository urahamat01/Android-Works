package com.mdrahamat.applicationlist;

public class Person {
    private String name;
    private String birthday;
    private String sex;

    public Person() {

    }

    public Person(String name, String birthday, String sex) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }
}
