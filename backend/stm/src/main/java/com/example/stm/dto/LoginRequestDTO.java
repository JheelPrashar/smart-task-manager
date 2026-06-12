package com.example.stm.dto;

public class LoginRequestDTO {
    private String username;
    private String password;

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword(){
        return password;
    }
    public void getPassword(String password){
        this.password=password;
    }


}
