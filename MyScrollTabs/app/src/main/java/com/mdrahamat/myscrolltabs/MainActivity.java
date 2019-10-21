package com.mdrahamat.myscrolltabs;


import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPageId);
        FragmentManager fragmentManager = getSupportFragmentManager();
        CustomAdapter customAdapter = new CustomAdapter(fragmentManager);
        viewPager.setAdapter(customAdapter);
    }
}

class CustomAdapter extends FragmentStatePagerAdapter {


    public CustomAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new FragmentOne();

        } else if (position == 1) {
            fragment = new FragmentTwo();

        } else if (position == 2) {
            fragment = new FragmentThree();

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "Tab1";
        }
        if (position == 1) {
            return "Tab2";
        }
        if (position == 2) {
            return "Tab3";
        }
        return null;
    }
}
