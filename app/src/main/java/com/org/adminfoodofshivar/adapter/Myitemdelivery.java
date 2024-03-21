package com.org.adminfoodofshivar.adapter;

public class Myitemdelivery {

    String name_item;
    String payment_name;
    String not_Received;
    String Delivered_name;
    int card_color;

    public Myitemdelivery(String name_item, String payment_name, String not_Received, String delivered_name, int card_color) {
        this.name_item = name_item;
        this.payment_name = payment_name;
        this.not_Received = not_Received;
        Delivered_name = delivered_name;
        this.card_color = card_color;
    }

    public String getName_item() {
        return name_item;
    }

    public void setName_item(String name_item) {
        this.name_item = name_item;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
    }

    public String getNot_Received() {
        return not_Received;
    }

    public void setNot_Received(String not_Received) {
        this.not_Received = not_Received;
    }

    public String getDelivered_name() {
        return Delivered_name;
    }

    public void setDelivered_name(String delivered_name) {
        Delivered_name = delivered_name;
    }

    public int getCard_color() {
        return card_color;
    }

    public void setCard_color(int card_color) {
        this.card_color = card_color;
    }
}
