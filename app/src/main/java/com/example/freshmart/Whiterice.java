package com.example.freshmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freshmart.Model.Carts;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Whiterice extends AppCompatActivity {

    private Button btn_cart,btn_increment,btn_decrement;
    private TextView productName,productPrice,productQty;
    int count=0;
    DatabaseReference reff;
    Carts carts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whiterice);

        btn_cart=findViewById(R.id.btnCart);
        btn_increment=findViewById(R.id.btnIncrement);
        btn_decrement=findViewById(R.id.btnDecrement);
        productName=findViewById(R.id.productName);
        productPrice=findViewById(R.id.productPrice);
        productQty=findViewById(R.id.productQty);

        reff= FirebaseDatabase.getInstance().getReference("Cart");
        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ID_cart=reff.push().getKey();

                String s_pname,s_pprice,s_pqty;
                s_pname=productName.getText().toString().trim();
                s_pprice=productPrice.getText().toString().trim();
                s_pqty=productQty.getText().toString().trim();

                HashMap<String, String> parameters = new HashMap<>();
                parameters.put("Product_name",s_pname);
                parameters.put("Product_price",s_pprice);
                parameters.put("Product_quanitity",s_pqty);
                reff.child(ID_cart).setValue(parameters);
                Toast.makeText(Whiterice.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Whiterice.this,Cart.class);
                startActivity(intent);
            }
        });

        btn_increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                productQty.setText(""+count);
            }
        });

        btn_decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<=0)
                    count=0;
                else
                    count--;
                productQty.setText(""+count);
            }
        });
    }

}