package com.example.tablayout2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewpagermessengeradapter extends FragmentPagerAdapter {


    public viewpagermessengeradapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new chatfragment();

        } else if (position==1) {
            return new AFragment();


        }
else return new BFragment();

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "chat";
        } else if (position==1) {

            return "Achat";
        }
        else {
            return "bchat";
        }
    }
}
