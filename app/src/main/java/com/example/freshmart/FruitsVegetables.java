package com.example.freshmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FruitsVegetables extends AppCompatActivity {

    ImageView apple, brinjal, ladysfinger, mango, cabbage, pineapple;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits_vegetables);

        apple=findViewById(R.id.apple);
        brinjal=findViewById(R.id.brinjal);
        mango=findViewById(R.id.mango);
        ladysfinger=findViewById(R.id.ladysfinger);
        cabbage=findViewById(R.id.cabbage);
        pineapple=findViewById(R.id.pineapple);

        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent apple_home=new Intent(FruitsVegetables.this, Apple.class);
                startActivity(apple_home);

            }
        });

        brinjal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent brinjal_home=new Intent(FruitsVegetables.this, BaseApp.Brinjal.class);
                startActivity(brinjal_home);

            }
        });

        pineapple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pineapple_home=new Intent(FruitsVegetables.this, Pineapple.class);
                startActivity(pineapple_home);

            }
        });

        ladysfinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lady_home=new Intent(FruitsVegetables.this, Ladyfinger.class);
                startActivity(lady_home);

            }
        });

        cabbage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cabbage_home=new Intent(FruitsVegetables.this, Cabbage.class);
                startActivity(cabbage_home);

            }
        });

        mango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mango_home=new Intent(FruitsVegetables.this, Mango.class);
                startActivity(mango_home);

            }
        });

    }
}