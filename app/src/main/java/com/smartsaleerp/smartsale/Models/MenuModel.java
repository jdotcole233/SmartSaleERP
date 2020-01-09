package com.smartsaleerp.smartsale.Models;

public class MenuModel {
    private  String foodname, image, foodDetails;
    private double price;


    public MenuModel(String foodname, String image, String foodDetails, double price) {
        this.foodname = foodname;
        this.image = image;
        this.foodDetails = foodDetails;
        this.price = price;
    }


    public String getFoodDetails() {
        return foodDetails;
    }

    public void setFoodDetails(String foodDetails) {
        this.foodDetails = foodDetails;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
