package com.pritz.sikkimuniversity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by pritz on 25/12/17.
 */

class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:Mainnotice mainnotice=new Mainnotice();
            return mainnotice;

            case 1:Story story=new Story();
            return story;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0:
                return "Notice Board";
            case 1:
                return "Stories";
            default:
                return null;
        }
    }
}
