package com.example.freshmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Foodgrains extends AppCompatActivity {

    ImageView whiterice,ragi,quinoa,oats,wheatcorn,basmati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodgrains);

        whiterice=findViewById(R.id.cloves);
        ragi=findViewById(R.id.turmeric);
        quinoa=findViewById(R.id.cinnamon);
        oats=findViewById(R.id.cardamom);
        wheatcorn=findViewById(R.id.fenugreek);
        basmati=findViewById(R.id.pepper);

        whiterice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent white_page=new Intent(Foodgrains.this,Whiterice.class);
                startActivity(white_page);
            }
        });

        ragi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ragi_page=new Intent(Foodgrains.this,Ragi.class);
                startActivity(ragi_page);
            }
        });

        quinoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quinoa_page=new Intent(Foodgrains.this,Quinoa.class);
                startActivity(quinoa_page);
            }
        });

        oats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oats_page=new Intent(Foodgrains.this,Oats.class);
                startActivity(oats_page);
            }
        });

        wheatcorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wheat_page=new Intent(Foodgrains.this,Wheatcorn.class);
                startActivity(wheat_page);
            }
        });

        basmati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent basmati_page=new Intent(Foodgrains.this,BasmatiRice.class);
                startActivity(basmati_page);
            }
        });
    }
}