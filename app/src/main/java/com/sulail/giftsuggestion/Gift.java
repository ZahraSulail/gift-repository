package com.sulail.giftsuggestion;

public class Gift {
    private int name;
    private int picture;

    /*
    Create Gift constructor
     */
    public Gift(int name, int picture){

        this.name = name;
        this.picture = picture;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
