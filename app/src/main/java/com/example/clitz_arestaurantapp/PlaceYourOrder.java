package com.example.clitz_arestaurantapp;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class PlaceYourOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_your_order);
        //getSupportActionBar().hide();

        Fragment deliveryFragment = new DeliveryFragment();
        Fragment qrCodeFragment = new QrCodeFragment();
        RadioButton dineInBtn = findViewById(R.id.dineInBtn);
        RadioButton deliveryBtn = findViewById(R.id.deliveryBtn);


        getSupportFragmentManager().beginTransaction().replace(R.id.flLayout, qrCodeFragment).commit();

        dineInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flLayout,qrCodeFragment ).commit();
            }
        });

        deliveryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flLayout, deliveryFragment).commit();
            }
        });

    }
}