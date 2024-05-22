package com.rutu12m.assign_1;

import java.io.Serializable;

public class food implements Serializable {
    private String Veg;
    private String NonVeg;

    public food() {
    }

    public food(String veg, String nonVeg) {
        Veg = veg;
        NonVeg = nonVeg;
    }

    public String getVeg() {
        return Veg;
    }

    public void setVeg(String veg) {
        Veg = veg;
    }

    public String getNonVeg() {
        return NonVeg;
    }

    public void setNonVeg(String nonVeg) {
        NonVeg = nonVeg;
    }

    @Override
    public String toString() {
        return "food{" +
                "Veg='" + Veg + '\'' +
                ", NonVeg='" + NonVeg + '\'' +
                '}';
    }
}
