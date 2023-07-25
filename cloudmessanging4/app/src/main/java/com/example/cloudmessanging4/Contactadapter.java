package com.example.cloudmessanging4;

public class Contactadapter {
    String name,lastname,Mobile,Email,Password,Confirmpassword;
    public Contactadapter(){

    }

    public Contactadapter(String name, String lastname, String mobile, String email, String password, String confirmpassword) {
        this.name = name;
        this.lastname = lastname;
        Mobile = mobile;
        Email = email;
        Password = password;
        Confirmpassword = confirmpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmpassword() {
        return Confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        Confirmpassword = confirmpassword;
    }
}
