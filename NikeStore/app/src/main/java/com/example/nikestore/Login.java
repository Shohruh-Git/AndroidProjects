package com.example.nikestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {


    TextView join_us;
    TextView forgot;
    EditText email,password;
    Button sign_in;
    String user_email,user_password;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    DatabaseReference firebaseDatabase;
    List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email_sign_in);
        progressBar = findViewById(R.id.progress_bar_sign);
        list = new ArrayList<>();
        password =findViewById(R.id.password_sign_in);
        sign_in = findViewById(R.id.sign_in_button);
        join_us = findViewById(R.id.join_us);
        user_email = email.getText().toString();
        user_password = password.getText().toString();
        forgot = findViewById(R.id.forgot_your_pass);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("Users");
        join_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, ResetPassword.class);
                startActivity(intent);
            }
        });
        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1: snapshot.getChildren())
                {
                    list.add(snapshot1.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                user_password = password.getText().toString();
                user_email = email.getText().toString();
                if(TextUtils.isEmpty(user_password))
                {

                    Toast toast = Toast.makeText(Login.this,"    Enter password    " , Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.toast_shape);
                    TextView text = (TextView) view.findViewById(android.R.id.message);
                    text.setTextColor(Color.parseColor("#000000"));
                    toast.show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
                else if(user_password.length() <6 )
                {
                    Toast toast = Toast.makeText(Login.this,"    Password is too short   " , Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.toast_shape);
                    TextView text = (TextView) view.findViewById(android.R.id.message);
                    text.setTextColor(Color.parseColor("#000000"));
                    toast.show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
                if(TextUtils.isEmpty(user_password))
                {
                    Toast toast = Toast.makeText(Login.this,"    Enter your email   " , Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.toast_shape);
                    TextView text = (TextView) view.findViewById(android.R.id.message);
                    text.setTextColor(Color.parseColor("#000000"));
                    toast.show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
                if(!TextUtils.isEmpty(user_password) && !TextUtils.isEmpty(user_email) && user_password.length() >6)
                {
                    firebaseAuth.signInWithEmailAndPassword(user_email,user_password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Intent intent = new Intent(Login.this , HomePage.class);
                                progressBar.setVisibility(View.INVISIBLE);
                                startActivity(intent);

                            }
                            else
                            {
                                Toast toast = Toast.makeText(Login.this,"    Authentication Failed!  " , Toast.LENGTH_SHORT);
                                View view = toast.getView();
                                view.setBackgroundResource(R.drawable.toast_shape);
                                TextView text = (TextView) view.findViewById(android.R.id.message);
                                text.setTextColor(Color.parseColor("#000000"));
                                progressBar.setVisibility(View.INVISIBLE);
                                toast.show();
                            }
                        }
                    });
                }
            }
        });
    }
}