package com.example.clitz_arestaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.SliderView;

public class AutoImageSlider extends AppCompatActivity {

    Button dbutton;
    SliderView sv;
    int[] images = {R.drawable.auto_image_slider_1,
            R.drawable.auto_image_slider_11,
            R.drawable.auto_image_slider_8,
            R.drawable.auto_image_slider_10,
            R.drawable.auto_image_slider_5,
            R.drawable.auto_image_slider_4,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_image_slider);
//        getSupportActionBar().hide();

        sv = findViewById(R.id.image_slider);

        // Auto Image Slider...
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sv.setSliderAdapter(sliderAdapter);
        sv.startAutoCycle();

        // Home Delivery Button...
        dbutton = findViewById(R.id.homeDeliveryButton);
        dbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Success!!!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),MenuList.class);
                startActivity(i);
                finish();
            }
        });
    }
}