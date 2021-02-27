package com.example.nikestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    TextView sign_in;

    ProgressBar bar;

    EditText email,password,name,last_name;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    Button join_us;
    String user_email,user_password,user_name,user_last_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        User user = new User();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        sign_in  = findViewById(R.id.sign_in_register);
        bar = findViewById(R.id.register_progress_bar);
        email = findViewById(R.id.email_sign_in);
        password = findViewById(R.id.password_register);
        name = findViewById(R.id.password_sign_in);
        last_name = findViewById(R.id.last_name_register);
        join_us = findViewById(R.id.sign_in_button);

        firebaseAuth = FirebaseAuth.getInstance();
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
        join_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_email = email.getText().toString();
                user_password = password.getText().toString();
                user_name = name.getText().toString();
                user_last_name = last_name.getText().toString();

                if(TextUtils.isEmpty(user_email))
                {
                    Toast toast = Toast.makeText(Register.this,"    Enter your email    " , Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.toast_shape);
                    TextView text = (TextView) view.findViewById(android.R.id.message);
                    text.setTextColor(Color.parseColor("#000000"));
                    toast.show();
                }
                else if(TextUtils.isEmpty(user_password))
                {
                    Toast toast = Toast.makeText(Register.this,"    Enter your password    " , Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.toast_shape);
                    TextView text = (TextView) view.findViewById(android.R.id.message);
                    text.setTextColor(Color.parseColor("#000000"));
                    toast.show();
                }
                else if(TextUtils.isEmpty(user_name))
                {
                    Toast toast = Toast.makeText(Register.this,"    Enter your name   " , Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.toast_shape);
                    TextView text = (TextView) view.findViewById(android.R.id.message);
                    text.setTextColor(Color.parseColor("#000000"));
                    toast.show();
                }
                else if(TextUtils.isEmpty(user_last_name))
                {
                    Toast toast = Toast.makeText(Register.this,"    Enter your last name    " , Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.toast_shape);
                    TextView text = (TextView) view.findViewById(android.R.id.message);
                    text.setTextColor(Color.parseColor("#000000"));
                    toast.show();
                }
                if(user_password.length() < 6){
                    Toast toast = Toast.makeText(Register.this,"    Password is too short    " , Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.toast_shape);
                    TextView text = (TextView) view.findViewById(android.R.id.message);
                    text.setTextColor(Color.parseColor("#000000"));
                    toast.show();
                }
                if(user_password.length()>6 && !user_email.isEmpty() && !user_password.isEmpty() && !user_last_name.isEmpty() && !user_name.isEmpty())
                {
                    bar.setVisibility(View.VISIBLE);
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(Register.this,new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful())
                          {
                              user.setName(user_name);
                              user.setLast_name(user_last_name);
                              bar.setVisibility(View.GONE);
                              databaseReference.setValue(user);
                              Intent intent = new Intent(Register.this , HomePage.class);
                              startActivity(intent);
                          }
                          else
                          {
                              bar.setVisibility(View.GONE);
                              Toast toast = Toast.makeText(Register.this,"    Authentication failed.    " , Toast.LENGTH_SHORT);
                              View view = toast.getView();
                              view.setBackgroundResource(R.drawable.toast_shape);
                              TextView text = (TextView) view.findViewById(android.R.id.message);
                              text.setTextColor(Color.parseColor("#000000"));
                              toast.show();
                          }
                        }
                    });

                }






            }
        });

    }
}