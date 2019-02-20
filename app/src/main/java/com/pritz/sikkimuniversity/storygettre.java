package com.pritz.sikkimuniversity;

public class storygettre {
String stitle,sdate,simage;

    public storygettre()
    {

    }
    public storygettre(String stitle, String sdate, String simage) {
        this.stitle = stitle;
        this.sdate = sdate;
        this.simage = simage;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }
}
