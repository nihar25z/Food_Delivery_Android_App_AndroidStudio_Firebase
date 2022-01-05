package com.example.clitz_arestaurantapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class HomeDeliveryLiquidSwipe extends AppCompatActivity {

    private static final int NUM_PAGES = 5;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_delivery_liquid_swipe);
//        getSupportActionBar().hide();

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{

        public ScreenSlidePagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    HDPage1Fragment tab1 = new HDPage1Fragment();
                    return tab1;
                case 1:
                    HDPage2Fragment tab2 = new HDPage2Fragment();
                    return tab2;
                case 2:
                    HDPage3Fragment tab3 = new HDPage3Fragment();
                    return tab3;
                case 3:
                    HDPage4Fragment tab4 = new HDPage4Fragment();
                    return tab4;
                case 4:
                    HDPage5Fragment tab5 = new HDPage5Fragment();
                    return tab5;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}

