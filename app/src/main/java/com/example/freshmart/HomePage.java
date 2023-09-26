package com.example.freshmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {

    ImageView iv_apple, iv_brinjal, iv_pineapple, iv_ladysfinger,
            iv_whiterice,iv_basmati, iv_ragi,iv_oats,iv_clove,
            iv_cinnamon, iv_turmeric,iv_cardamom,
            iv_arrow1, iv_arrow2, iv_arrow3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        iv_apple=findViewById(R.id.iv_apple);
        iv_brinjal=findViewById(R.id.iv_brinjal);
        iv_pineapple=findViewById(R.id.iv_pineapple);
        iv_ladysfinger=findViewById(R.id.iv_ladyfinger);
        iv_whiterice=findViewById(R.id.iv_whiterice);
        iv_basmati=findViewById(R.id.iv_basmati);
        iv_ragi=findViewById(R.id.iv_ragi);
        iv_oats=findViewById(R.id.iv_oats);
        iv_clove=findViewById(R.id.iv_clove);
        iv_cinnamon=findViewById(R.id.iv_cinnamon);
        iv_cardamom=findViewById(R.id.iv_cardamom);
        iv_turmeric=findViewById(R.id.iv_turmeric);
        iv_arrow1=findViewById(R.id.iv_arrow1);
        iv_arrow2=findViewById(R.id.iv_arrow2);
        iv_arrow3=findViewById(R.id.iv_arrow3);
        iv_apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent apple_page=new Intent(HomePage.this,Apple.class);
                startActivity(apple_page);
            }
        });

        iv_brinjal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent brinjal_page=new Intent(HomePage.this, BaseApp.Brinjal.class);
                startActivity(brinjal_page);
            }
        });

        iv_pineapple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pineapple_page=new Intent(HomePage.this,Pineapple.class);
                startActivity(pineapple_page);
            }
        });

        iv_ladysfinger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ladysfinger_page=new Intent(HomePage.this,Ladyfinger.class);
                startActivity(ladysfinger_page);
            }
        });

        iv_whiterice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whiterice_page=new Intent(HomePage.this,Whiterice.class);
                startActivity(whiterice_page);
            }
        });

        iv_oats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oats_page=new Intent(HomePage.this,Oats.class);
                startActivity(oats_page);
            }
        });

        iv_ragi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ragi_page=new Intent(HomePage.this,Ragi.class);
                startActivity(ragi_page);
            }
        });

        iv_basmati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent basmati_page=new Intent(HomePage.this,BasmatiRice.class);
                startActivity(basmati_page);
            }
        });

        iv_clove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clove_page=new Intent(HomePage.this,Clove.class);
                startActivity(clove_page);
            }
        });

        iv_cardamom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardamom_page=new Intent(HomePage.this,Cardamom.class);
                startActivity(cardamom_page);
            }
        });

        iv_cinnamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cinnamon_page=new Intent(HomePage.this,Cinnamon.class);
                startActivity(cinnamon_page);
            }
        });

        iv_turmeric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent turmeric_page=new Intent(HomePage.this,Turmeric.class);
                startActivity(turmeric_page);
            }
        });

        iv_arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent arrow_page=new Intent(HomePage.this,FruitsVegetables.class);
                startActivity(arrow_page);
            }
        });

        iv_arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent arrow2_page=new Intent(HomePage.this,Foodgrains.class);
                startActivity(arrow2_page);
            }
        });

        iv_arrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent arrow_page=new Intent(HomePage.this,Spices.class);
                startActivity(arrow_page);
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

            case R.id.addproduct:
                Intent add_product_page=new Intent(this,AdminAddNewProductActivity.class);
                startActivity(add_product_page);
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