package com.example.gapgram.model;

public class Contact {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;
    public  Contact(){
        this.email = "a@gmail.com";
    }
    public  void deleteMail(){
        this.email="";

    }
}
