package com.rutu12m.assign_5;

import java.io.Serializable;

public class Employee implements Serializable {
    private int image;
    private String name;
    private String desg;

    public Employee() {
    }

    public Employee(int image, String name, String desg) {
        this.image = image;
        this.name = name;
        this.desg = desg;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesg() {
        return desg;
    }

    public void setDesg(String desg) {
        this.desg = desg;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", desg='" + desg + '\'' +
                '}';
    }
}
