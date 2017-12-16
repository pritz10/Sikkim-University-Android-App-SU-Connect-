package com.pritz.sikkimuniversity;

/**
 * Created by pritz on 24/7/17.
 */

public class imp {
    private String name;
    private String date;
    private String image;
    private String message;
    private String seen;


    public imp()
    {

    }
    public imp(String name, String date, String message,String image,String seen){
        this.name=name;
        this.date=date;
        this.message=message;
        this.image=image;
       this.seen=seen;

    }

    public String getSeen() {
        return seen;
    }

    public void setSeen(String seen) {
        this.seen = seen;
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