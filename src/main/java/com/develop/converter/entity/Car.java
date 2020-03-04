package com.develop.converter.entity;

public class Car {

    String date;
    String brandName;
    String price;

    public Car() {

    }

    public Car(String date, String brandName, String price) {
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

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}
