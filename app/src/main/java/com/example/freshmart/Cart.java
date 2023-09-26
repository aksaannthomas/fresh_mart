package com.example.freshmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.freshmart.Model.Carts;
import com.example.freshmart.Prevalent.Prevalent;
import com.example.freshmart.ViewHolder.CartViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {

    private Button btnPayment;
    private RecyclerView recyclerView;
    private List<Carts> showCart_modelList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView=findViewById(R.id.cart_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        btnPayment=findViewById(R.id.btnPayment);


        DatabaseReference show_info=FirebaseDatabase.getInstance().getReference("Cart");
        show_info.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    showCart_modelList.clear();
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        Carts carts= snapshot1.getValue(Carts.class);
                        showCart_modelList.add(carts);
                    }
                    recyclerView.setAdapter(new CartViewHolder(getApplicationContext(),showCart_modelList));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent payment_page=new Intent(Cart.this,PaymentActivity.class);
                startActivity(payment_page);
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