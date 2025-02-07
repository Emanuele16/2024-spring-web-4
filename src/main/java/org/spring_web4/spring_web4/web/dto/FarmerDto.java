package org.spring_web4.spring_web4.web.dto;

import org.spring_web4.spring_web4.db.pojo.Farm;

public class FarmerDto {
    private String name;
    private String surname;
    private int age;
    private Farm farm;

    public FarmerDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
