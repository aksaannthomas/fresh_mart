package com.example.freshmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    RadioButton r1,r2,r3;
    Button btn1, btn2;
    EditText e1, e2, e3, e4;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        r1=findViewById(R.id.radioCredit);
        r2=findViewById(R.id.radioDebit);
        r3=findViewById(R.id.radioCash);
        btn1=findViewById(R.id.btnPlaceOrder);
        btn2=findViewById(R.id.btnPay);
        e1=findViewById(R.id.etCardNo);
        e2=findViewById(R.id.etMM);
        e3=findViewById(R.id.etYY);
        e4=findViewById(R.id.etCVV);
        tv=findViewById(R.id.tvSlash);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r1.isChecked() || r2.isChecked()){
                    e1.setVisibility(View.VISIBLE);
                    e2.setVisibility(View.VISIBLE);
                    e3.setVisibility(View.VISIBLE);
                    e4.setVisibility(View.VISIBLE);
                    tv.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                }

                else if(r3.isChecked()){
                    e1.setVisibility(View.INVISIBLE);
                    e2.setVisibility(View.INVISIBLE);
                    e3.setVisibility(View.INVISIBLE);
                    e4.setVisibility(View.INVISIBLE);
                    tv.setVisibility(View.INVISIBLE);
                    btn2.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Order Placed!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentActivity.this, "Payment successful!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.iconmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent home_page = new Intent(this, HomePage.class);
                startActivity(home_page);
                break;

            case R.id.profile:
                Intent profile_page = new Intent(this, Profile.class);
                startActivity(profile_page);
                break;

            case R.id.order:
                Intent orderpage = new Intent(this, Orders.class);
                startActivity(orderpage);
                break;

            case R.id.cart:
                Intent cart_page = new Intent(this, Cart.class);
                startActivity(cart_page);
                break;

            case R.id.logout:
                Intent logout_page = new Intent(this, MainActivity.class);
                logout_page.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logout_page);
                break;


        }
        return true;
    }

}