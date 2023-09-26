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

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button submit;
    TextView signup,skip,forgotPassword;
    FirebaseAuth auth;
    String s_email,s_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.et_email_login);
        password=findViewById(R.id.et_password_login);
        submit=findViewById(R.id.bt_submit);
        signup = findViewById(R.id.et_signup);
        skip=findViewById(R.id.tv_skip);
        forgotPassword=findViewById(R.id.tv_forgotPassword);
        auth=FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s_email=email.getText().toString().trim();
                s_password=password.getText().toString().trim();

                auth.signInWithEmailAndPassword(s_email,s_password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(MainActivity.this,HomePage.class);
                                    startActivity(intent);
                                }
                            }

                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });

                
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register_intent=new Intent(MainActivity.this,CreateAccount.class);
                startActivity(register_intent);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home_intent=new Intent(MainActivity.this,HomePage.class);
                startActivity(home_intent);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotpass_intent=new Intent(MainActivity.this,ForgotPassword.class);
                startActivity(forgotpass_intent);
            }
        });


    }
}