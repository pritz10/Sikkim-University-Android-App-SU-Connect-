package com.pritz.sikkimuniversity;

public class forstory {

    String sdate,simage,stitle;
    public forstory()
    {}

    public forstory(String sdate, String simage, String stitle) {
        this.sdate = sdate;
        this.simage = simage;
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

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }
}
