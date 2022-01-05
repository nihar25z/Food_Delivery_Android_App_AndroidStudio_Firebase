package com.example.clitz_arestaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DineInOrderPlaced extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in_order_placed);

        TextView tableNumber = findViewById(R.id.tableNumber);

        Intent i = getIntent();
        String str = getIntent().getStringExtra("QR");

        tableNumber.setText(str);
    }
}