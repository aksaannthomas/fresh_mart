package com.example.freshmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Wheatcorn extends AppCompatActivity {

    Button btn_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheatcorn);

        btn_cart=findViewById(R.id.btnCart);
        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Wheatcorn.this, Cart.class);
                startActivity(intent);
            }
        });
    }
}