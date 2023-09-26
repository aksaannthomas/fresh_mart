package com.example.freshmart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDexApplication;

public class BaseApp extends MultiDexApplication {
    public static class Brinjal extends AppCompatActivity {

        Button btn_cart;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_brinjal);

            btn_cart=findViewById(R.id.btnCart);
            btn_cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Brinjal.this,Cart.class);
                    startActivity(intent);
                }
            });
        }
    }
}
