package com.pritz.sikkimuniversity;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by user on 2/28/2017.
 */
public class Chat {
   // Pronounciation call=new Pronounciation();
    String name,mess;



    public Chat()
    {

    }
    public Chat(String name,String mess)
    {
        this.name=name;
        this.mess= mess;
    }
    public String getName()
    {

        return name;
    }
    public String getMess()
    {
            return mess;
    }

}
