package com.example.freshmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccount extends AppCompatActivity {

    EditText name,email,address,contactno,password;
    TextView signin;
    Button create_button;
    FirebaseAuth auth;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        name=findViewById(R.id.et_name);
        address=findViewById(R.id.et_address);
        email=findViewById(R.id.et_email);
        contactno=findViewById(R.id.et_contactno);
        password=findViewById(R.id.et_password);
        signin=findViewById(R.id.tvSignIn);
        create_button=findViewById(R.id.create_button);

        auth= FirebaseAuth.getInstance();
        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CreateAccount.this,MainActivity.class);
                startActivity(intent);
            }
        });

        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s_name,s_email,s_address,s_password;
                Long s_contact;
                s_name=name.getText().toString().trim();
                s_email=email.getText().toString().trim();
                s_address=address.getText().toString().trim();
                s_contact=Long.parseLong(contactno.getText().toString().trim());
                s_password=password.getText().toString().trim();

                member.setName(s_name);
                member.setEmail(s_email);
                member.setAddress(s_address);
                member.setContactNo(s_contact);

                reff.push().setValue(member);
                Toast.makeText(CreateAccount.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

                auth.createUserWithEmailAndPassword(s_email,s_password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(CreateAccount.this, "User signed up successfully", Toast.LENGTH_SHORT).show();
                            }
                        })

                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(CreateAccount.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}