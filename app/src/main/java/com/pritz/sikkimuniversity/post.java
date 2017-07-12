package com.pritz.sikkimuniversity;

/**
 * Created by pritz on 15/3/17.
 */

public class post {

    private String title,detail,image,Username,date;

  /*  public post(String title,String detail,String image,String Username)
    {

        this.title=title;
        this.detail=detail;
        this.image=image;
        this.Username=Username;
    }*/
    public String getUsername()
    {
        return Username;
    }

    public void setUsername(String Username)
    {
        this.Username = Username;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getTitle() {

        return title;
    }
    public void setTitle(String title)

    {
        this.title = title;
    }
    public String getDate()
    {
        return date;
    }

    public void setDate(String Username)
    {
        this.date = date;
    }



}
