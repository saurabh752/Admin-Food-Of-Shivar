package com.org.adminfoodofshivar;

public class DataHolderFirebase {
    String Image,Ingredients,Name,Price, Description;

    public DataHolderFirebase(String image, String ingredients, String name, String price, String description) {
        Image = image;
        Ingredients = ingredients;
        Name = name;
        Price = price;
        Description = description;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
