package com.org.adminfoodofshivar.adapter;

public class Model {
    String Name,Price,Image,Ingredients,Description;


    Model(){

    }

    public Model(String name, String price, String image, String ingredients, String description) {
        Name = name;
        Price = price;
        Image = image;
        Ingredients = ingredients;
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
