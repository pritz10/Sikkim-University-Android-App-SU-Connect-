package com.pritz.sikkimuniversity;


public class lost  // for initializing //
{

        String ltitle,ldetail;
        public lost()
        {

        }
        public lost(String ltitle,String ldetail)
        {
            this.ltitle=ltitle; // for title of lost/found//
            this.ldetail=ldetail; // for detail of lost/found
        }
        public String getT()
        {
            return ltitle;
        } //method for returning the title Sikim//
        public String getD()
        {
            return ldetail;
        } /////////////// method for returning the detail Sikim//

    }

