package com.pritz.sikkimuniversity;

/**
 * Created by rob on 12/3/17.
 */

public class GetterandSetter {
    private String name;
    private String date;
    private String message;


    public GetterandSetter()
    {

    }
    public GetterandSetter(String name, String date, String message){
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


