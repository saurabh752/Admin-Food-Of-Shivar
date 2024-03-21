package com.org.adminfoodofshivar.adapter;

public class MyItemPending {


    int image_pending;
    String name_customer;
    String Food_quantity;
     String price;
     String accept_btn;
    private boolean isAccepted;

    public MyItemPending(int image_pending, String name_customer, String food_quantity, String price, String accept_btn) {
        this.image_pending = image_pending;
        this.name_customer = name_customer;
        Food_quantity = food_quantity;
        this.price = price;
        this.accept_btn = accept_btn;
        this.isAccepted = false; // Default status is not accepted
    }

    public int getImage_pending() {
        return image_pending;
    }

    public void setImage_pending(int image_pending) {
        this.image_pending = image_pending;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getFood_quantity() {
        return Food_quantity;
    }

    public void setFood_quantity(String food_quantity) {
        Food_quantity = food_quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAccept_btn() {
        return accept_btn;
    }

    public void setAccept_btn(String accept_btn) {
        this.accept_btn = accept_btn;
    }
    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
