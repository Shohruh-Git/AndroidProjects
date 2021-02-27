package com.example.nikestore.model;

public class NewRelease {
    public NewRelease(String name, String imageUrl, String gender, String price,String rating) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.gender = gender;
        this.price = price;
        this.rating = rating;
    }
    public NewRelease(

    ){};
    String rating;
    public String getRating(){
        return rating;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String name;
    private String imageUrl;
    private String gender;
    private String price;
}
