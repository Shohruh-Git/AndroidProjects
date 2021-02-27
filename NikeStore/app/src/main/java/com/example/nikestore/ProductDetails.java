package com.example.nikestore;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.SystemClock;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;


public class ProductDetails extends AppCompatActivity {

    ImageView heart,empty_heart;
    ImageView back;
    Button button29,button30,button31,button32,button33,prev_button;
    boolean isLiked = true;
    ImageView big_shoe;
    Button buy;
    TextView rating,name,price;
    LottieAnimationView animationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        rating = findViewById(R.id.big_shoe_rating);
        name = findViewById(R.id.big_shoe_name);
        price = findViewById(R.id.big_shoe_price);
        heart= findViewById(R.id.big_shoe_cart);
        empty_heart = findViewById(R.id.big_shoe_like_empty);
        back  = findViewById(R.id.menu);
        buy = findViewById(R.id.buy_now_button);
        animationView = findViewById(R.id.animation);
        big_shoe = findViewById(R.id.big_shoe_image);
        button29 = findViewById(R.id.button29);
        button30 = findViewById(R.id.button30);
        button31 = findViewById(R.id.button31);
        button32 = findViewById(R.id.button32);
        button33 = findViewById(R.id.button33);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        price.setText(intent.getStringExtra("price"));
        rating.setText(intent.getStringExtra("rating"));
        prev_button = button29;
        boolean isBlack = false;
        button29.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                prev_button.setTextColor(Color.BLACK);
                prev_button.setBackgroundColor(Color.WHITE);
                prev_button = button29;
                button29.setBackgroundColor(Color.BLACK);
                button29.setTextColor(Color.WHITE);

            }
        });
        button30.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                prev_button.setTextColor(Color.BLACK);
                prev_button.setBackgroundColor(Color.WHITE);
                prev_button = button30;
                button30.setBackgroundColor(Color.BLACK);
                button30.setTextColor(Color.WHITE);
            }
        });
        button31.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                prev_button.setTextColor(Color.BLACK);
                prev_button.setBackgroundColor(Color.WHITE);
                prev_button = button31;
                button31.setBackgroundColor(Color.BLACK);
                button31.setTextColor(Color.WHITE);
            }
        });
        button32.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                prev_button.setTextColor(Color.BLACK);
                prev_button.setBackgroundColor(Color.WHITE);
                prev_button = button32;
                button32.setBackgroundColor(Color.BLACK);
                button32.setTextColor(Color.WHITE);
            }
        });
        button33.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                prev_button.setTextColor(Color.BLACK);
                prev_button.setBackgroundColor(Color.WHITE);
                prev_button = button33;
                button33.setBackgroundColor(Color.BLACK);
                button33.setTextColor(Color.WHITE);
            }
        });






        empty_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isLiked){
                heart.setAlpha(0f);
                empty_heart.setAlpha(1f);
                Toast toast = Toast.makeText(ProductDetails.this , "Liked ! " , Toast.LENGTH_SHORT);
                toast.show();
                isLiked = false;
                }
                else
                {
                    empty_heart.setAlpha(0f);
                    heart.setAlpha(1f);
                    Toast toast = Toast.makeText(ProductDetails.this , "Disliked ! " , Toast.LENGTH_SHORT);
                    toast.show();
                    isLiked = true;
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetails.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(ProductDetails.this , "Button clicked" , Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        big_shoe.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick() {
                animationView.setAlpha(1f);
                animationView.playAnimation();
                animationView.animate().setStartDelay(1000).alpha(0f);
                heart.animate().setDuration(500).alpha(0f);
                empty_heart.animate().setDuration(500).alpha(1f);
                isLiked = false;

            }
        });




    }
    // reference
    //https://gist.github.com/srix55/ec64d2f6a371c80bbbc4#file-doubleclicklistener-java-L1
    public abstract class DoubleClickListener implements OnClickListener {

        // The time in which the second tap should be done in order to qualify as
        // a double click
        private static final long DEFAULT_QUALIFICATION_SPAN = 200;
        private long doubleClickQualificationSpanInMillis;
        private long timestampLastClick;

        public DoubleClickListener() {
            doubleClickQualificationSpanInMillis = DEFAULT_QUALIFICATION_SPAN;
            timestampLastClick = 0;
        }

        public DoubleClickListener(long doubleClickQualificationSpanInMillis) {
            this.doubleClickQualificationSpanInMillis = doubleClickQualificationSpanInMillis;
            timestampLastClick = 0;
        }

        @Override
        public void onClick(View v) {
            if((SystemClock.elapsedRealtime() - timestampLastClick) < doubleClickQualificationSpanInMillis) {
                onDoubleClick();
            }
            timestampLastClick = SystemClock.elapsedRealtime();
        }

        public abstract void onDoubleClick();

    }

}