package com.develop.converter.entity;

import java.util.Date;

public class Car {

    Date date;
    String brandName;
    Integer price;

    public Car() {
    }

    public Car(Date date, String brandName, Integer price) {
        this.date = date;
        this.brandName = brandName;
        this.price = price;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
