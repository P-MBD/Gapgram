package com.example.gapgram.model;

import javax.inject.Inject;

public class User {
    Contact contact;
    @Inject
    public  User(Contact contact){
        this.contact = contact;
    }
    public  void deleteUserMail(){
        contact.deleteMail();
    }
    public String getUserContact(){
        return  contact.getEmail();
    }
    public void setUserContact(String email){
        contact.setEmail(email);
    }
}
