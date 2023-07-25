package com.example.realtimedatabse;

public class contactmodel {
    String name;
    String contact;
     contactmodel(String name,String conctact){
         this.name=name;
         this.contact=conctact;
    }
    contactmodel(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
