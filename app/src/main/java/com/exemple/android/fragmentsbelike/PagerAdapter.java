package com.exemple.android.fragmentsbelike;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int mNumbersOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        mNumbersOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0 :
                return new chatFragment();
            case 1 :
                return new CallFragment();
            case 2 :
                return new NoteFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount(){ return mNumbersOfTabs;}
}
