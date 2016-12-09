package com.example.airlan.mvp;

/**
 * Created by Airlan on 2016/8/11.
 */
public class User {
    private String userName;
    private String passWord;

    public User(){

    }

    public User(String name,String number){
        userName=name;
        passWord=number;
    }

   void setName(String name){
       userName=name;
   }

   void setNumber(String number){
       passWord=number;
   }

    String getUserName(){
        return userName;
    }

    String getPassWord(){
        return passWord;
    }
}
