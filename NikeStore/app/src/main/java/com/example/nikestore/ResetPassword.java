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
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    TextView return_to_login;
    EditText reset;
    Button button;
    ProgressBar bar;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        return_to_login = findViewById(R.id.return_to_login);
        button = findViewById(R.id.reset_button);
        reset = findViewById(R.id.email_reset);
        bar = findViewById(R.id.progressBar);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        return_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPassword.this , Login.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                email = reset.getText().toString();
                bar.setVisibility(View.VISIBLE);
                if(TextUtils.isEmpty(email))
                {
                    Toast toast = Toast.makeText(ResetPassword.this,"    Enter Email    " , Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.setBackgroundResource(R.drawable.toast_shape);
                    TextView text = (TextView) view.findViewById(android.R.id.message);
                    text.setTextColor(Color.parseColor("#000000"));
                    toast.show();
                    bar.setVisibility(View.INVISIBLE);
                }
                else
                {
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast toast = Toast.makeText(ResetPassword.this,"    Instructions has been sent!    " , Toast.LENGTH_SHORT);
                                View view = toast.getView();
                                view.setBackgroundResource(R.drawable.toast_shape);
                                TextView text = (TextView) view.findViewById(android.R.id.message);
                                text.setTextColor(Color.parseColor("#000000"));
                                reset.setText("");
                                toast.show();
                                bar.setVisibility(View.INVISIBLE);
                            }
                            else
                            {
                                Toast toast = Toast.makeText(ResetPassword.this,"   Email doesn't exist   " , Toast.LENGTH_SHORT);
                                View view = toast.getView();
                                view.setBackgroundResource(R.drawable.toast_shape);
                                TextView text = (TextView) view.findViewById(android.R.id.message);
                                text.setTextColor(Color.parseColor("#000000"));
                                toast.show();
                                bar.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
            }
        });

    }
}