package com.pritz.sikkimuniversity;

/**
 * Created by pritz on 18/7/17.
 */

public class blood_gettersetter {
    String blodgrp;
    String image;
    String name;
    public blood_gettersetter()
    {

    }
    public blood_gettersetter(String bldgrp, String name, String image)
    {
        this.blodgrp=bldgrp;
        this.name=name;
        this.image=image;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBlodgrp() {
        return blodgrp;
    }

    public void setBlodgrp(String blodgrp) {
        this.blodgrp = blodgrp;
    }


}
