package com.example.freshmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Spices extends AppCompatActivity {

    ImageView clove, cardamom, cinnamon, pepper, fenugreek, turmeric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spices);

        clove=findViewById(R.id.cloves);
        cardamom=findViewById(R.id.cardamom);
        cinnamon=findViewById(R.id.cinnamon);
        pepper=findViewById(R.id.pepper);
        fenugreek=findViewById(R.id.fenugreek);
        turmeric=findViewById(R.id.turmeric);

        clove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cl_page=new Intent(Spices.this, Clove.class);
                startActivity(cl_page);
            }
        });

        pepper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pep_page=new Intent(Spices.this, Pepper.class);
                startActivity(pep_page);
            }
        });

        cardamom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent card_page=new Intent(Spices.this, Cardamom.class);
                startActivity(card_page);
            }
        });

        cinnamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cin_page=new Intent(Spices.this, Cinnamon.class);
                startActivity(cin_page);
            }
        });

        turmeric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent turm_page=new Intent(Spices.this, Turmeric.class);
                startActivity(turm_page);
            }
        });

        fenugreek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fen_page=new Intent(Spices.this, Fenugreek.class);
                startActivity(fen_page);
            }
        });
    }
}