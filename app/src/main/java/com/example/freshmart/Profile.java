package com.example.freshmart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Profile extends AppCompatActivity {

    Button btn_update;
    TextView name,email,address,contact;
    DatabaseReference reff;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name=findViewById(R.id.tvName);
        email=findViewById(R.id.tvEmail);
        address=findViewById(R.id.tvAddress);
        contact=findViewById(R.id.tvContact);
        btn_update=findViewById(R.id.btnUpdate);

        auth= FirebaseAuth.getInstance();
        String uid=auth.getCurrentUser().getUid();
        reff= FirebaseDatabase.getInstance().getReference("Member");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s_name=snapshot.child(uid).child("name").getValue().toString();
                String s_email=snapshot.child(uid).child("email").getValue().toString();
                String s_address=snapshot.child(uid).child("address").getValue().toString();
                String s_contact=snapshot.child(uid).child("contactNo").getValue().toString();
                name.setText(s_name);
                email.setText(s_email);
                address.setText(s_address);
                contact.setText(s_contact);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Profile.this, "NETWORK ERROR! Please check your network connection", Toast.LENGTH_SHORT).show();
            }
        });
      /*  reff.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String s_name=snapshot.child(uid).child("name").getValue().toString();
                String s_email=snapshot.child(uid).child("email").getValue().toString();
                String s_address=snapshot.child(uid).child("address").getValue().toString();
                String s_contact=snapshot.child(uid).child("contactNo").getValue().toString();
                name.setText(s_name);
                email.setText(s_email);
                address.setText(s_address);
                contact.setText(s_contact);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {


                String s_name=snapshot.child(uid).child("name").getValue().toString();
                String s_email=snapshot.child(uid).child("email").getValue().toString();
                String s_address=snapshot.child(uid).child("address").getValue().toString();
                String s_contact=snapshot.child(uid).child("contactNo").getValue().toString();
                name.setText(s_name);
                email.setText(s_email);
                address.setText(s_address);
                contact.setText(s_contact);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Profile.this,ProfileUpdate.class);
                startActivity(intent);
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