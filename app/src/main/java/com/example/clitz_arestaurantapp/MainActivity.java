package com.example.clitz_arestaurantapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//        getSupportActionBar().hide();

        ConstraintLayout cl;
        cl = findViewById(R.id.layoutConstraintImage);
        cl.getBackground().setAlpha(200);

        TabLayout tablayout;
        ViewPager viewpager;

        tablayout = findViewById(R.id.tab_layout);
        viewpager = findViewById(R.id.view_pager);

        tablayout.addTab(tablayout.newTab().setText("Log In"));
        tablayout.addTab(tablayout.newTab().setText("Sign Up"));
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),this, tablayout.getTabCount());
        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        viewpager.setAdapter(adapter);

    }
}
