package com.pritz.sikkimuniversity;

/**
 * Created by pritz on 24/7/17.
 */

public class imp {
    private String name;
    private String date;
    private String image;
    private String message;


    public imp()
    {

    }
    public imp(String name, String date, String message,String image){
        this.name=name;
        this.date=date;
        this.message=message;
        this.image=image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}