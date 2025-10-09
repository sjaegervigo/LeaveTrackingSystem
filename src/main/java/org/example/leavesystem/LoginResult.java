package org.example.leavesystem;

public class LoginResult {

    private Boolean granted;
    private User user;

    public LoginResult(Boolean granted, User user){
        this.granted = granted;
        this.user = user;
    }

    public Boolean isGranted(){
        return this.granted;
    }

    public User getUser(){
        return this.user;
    }

}
