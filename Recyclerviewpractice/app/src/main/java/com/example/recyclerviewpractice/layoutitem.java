package com.example.recyclerviewpractice;

public class layoutitem {
    int img;
    String name;
    String number;

    public layoutitem(int img,String name,String number){
        this.img=img;
        this.name=name;
        this.number=number;

    }
    public layoutitem(String name,String contact){
        this.name=name;
        this.number=contact;

    }
}
