package com.pritz.sikkimuniversity;

/**
 * Created by pritz on 24/7/17.
 */

public class notifi {
    private String name;
    private String date;
    private String message;


    public notifi()
    {

    }
    public notifi(String name, String date, String message){
        this.name=name;
        this.date=date;
        this.message=message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}