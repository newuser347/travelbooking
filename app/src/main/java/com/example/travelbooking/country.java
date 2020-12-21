package com.example.travelbooking;

public class country {

    private String cCap;
    private String cImg;

    public country(String cName, String cCap, String cImg) {

        this.cCap = cCap;
        this.cImg = cImg;
    }



    public String getcCap() {
        return cCap;
    }

    public String getcImg() {
        return cImg;
    }
}
