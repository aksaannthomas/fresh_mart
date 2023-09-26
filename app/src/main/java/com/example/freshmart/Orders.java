package com.example.freshmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Orders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        Toast.makeText(this, "No orders made yet!!", Toast.LENGTH_SHORT).show();

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

