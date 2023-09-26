package com.example.freshmart;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

public class toolbar extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
        toolbar1=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar1,R.string.navigation_draw_open,R.string.navigation_draw_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }


}

