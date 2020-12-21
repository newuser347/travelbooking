package com.example.travelbooking;

public class Place {
    private String pName;
    private double pPrice;
    private String pImage;

    public Place(String pName, double pPrice, String pImage) {
        this.pName = pName;
        this.pPrice = pPrice;
        this.pImage = pImage;
    }

    public String getpName() {
        return pName;
    }

    public double getpPrice() {
        return pPrice;
    }

    public String getpImage() {
        return pImage;
    }
}
