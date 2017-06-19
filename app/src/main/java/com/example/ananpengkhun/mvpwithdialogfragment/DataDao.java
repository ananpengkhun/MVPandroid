package com.example.ananpengkhun.mvpwithdialogfragment;

import io.realm.RealmObject;

/**
 * Created by ananpengkhun on 6/16/17.
 */

public class DataDao extends RealmObject {

    /**
     * quantity : 0
     * price : 200
     * name : Maguro
     * image : http://www.sabanbrands.com/img/original/FpoImages/901.f492d24767ed3a688f959ef7f419f849.jpg
     * description : Fat tuna
     */

    private int quantity;
    private int price;
    private String name;
    private String image;
    private String description;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
