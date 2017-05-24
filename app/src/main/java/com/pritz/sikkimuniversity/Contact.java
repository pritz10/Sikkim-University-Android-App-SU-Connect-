package com.pritz.sikkimuniversity;

/**
 * Created by Alaeddin on 5/14/2017.
 */

public class Contact {
    int Id;
    String Name,Email,UserName,Password;


   // public  void SetId(int id){this.Id=id; }
    //public  int GetId(){return Id;}

    public void SetName(String name){
        this.Name=name;
    }
    public String GetName(){
        return Name;
    }

    public void SetEmail(String email){
        this.Email=email;
    }
    public String GetEmail(){
        return Email;

    }

    public void SetUserName(String username){
        this.UserName=username;
    }
    public String GetUserName(){
        return UserName;
    }

    public void SetPassword(String password){
        this.Password=password;
    }

    public String GetPassword(){
        return Password;
    }
}

