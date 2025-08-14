package com.example.customlistviewapp;

public class Phone {
    private String namephone;
    private int imagephone;
    private String pricephone;

    public Phone(String namephone, int imagephone, String pricephone) {
        this.namephone = namephone;
        this.imagephone = imagephone;
        this.pricephone = pricephone;
    }

    public String getNamephone() {
        return namephone;
    }

    public void setNamephone(String namephone) {
        this.namephone = namephone;
    }

    public int getImagephone() {
        return imagephone;
    }

    public void setImagephone(int imagephone) {
        this.imagephone = imagephone;
    }

    public String getPricephone() {
        return pricephone;
    }

    public void setPricephone(String pricephone) {
        this.pricephone = pricephone;
    }
}
