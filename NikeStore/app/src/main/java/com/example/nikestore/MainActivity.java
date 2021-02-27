package com.example.nikestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nikestore.adapter.BestSellerAdapter;
import com.example.nikestore.adapter.NewReleaseRecyclerAdapter;
import com.example.nikestore.model.BestSeller;
import com.example.nikestore.model.NewRelease;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    NewReleaseRecyclerAdapter releaseRecyclerAdapter;
    BestSellerAdapter bestSellerAdapter;
    List<NewRelease> newReleaseList;
    List<BestSeller> bestSellerList;
    ImageView cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newReleaseList = new ArrayList<>();
        NewRelease item1 = new NewRelease("AIR MAX", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/nikestore/shoe1.png", "MEN", "$100","4.3");
        NewRelease item2 = new NewRelease("AIR MAX 200", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/nikestore/shoe2.png", "MEN", "$200","3.9");
        NewRelease item3 = new NewRelease("AIR MAX 100", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/nikestore/shoe3.png", "MEN", "$150","4.5");
        NewRelease item4 = new NewRelease("AIR PRO 120", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/nikestore/shoe4.png", "MEN", "$300","4.6");
        NewRelease item5 = new NewRelease("NIKE MAX", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/nikestore/shoe5.png", "MEN", "$120","4.8");
        newReleaseList.add(item1);
        newReleaseList.add(item2);
        newReleaseList.add(item3);
        newReleaseList.add(item4);
        newReleaseList.add(item5);
        setUserRecycler(newReleaseList);
        bestSellerList = new ArrayList<>();
        BestSeller i1 = new BestSeller("AIR MAX", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/nikestore/small_shoe1.png", "3.9", "$100" , "AIR");
        BestSeller i2 = new BestSeller("AIR MAX 200", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/nikestore/small_shoe2.png", "4.5", "$200" ,"PRO");
        BestSeller i3 = new BestSeller("AIR MAX 100", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/nikestore/small_shoe3.png", "4.8", "$150","SPORT");
        BestSeller i4 = new BestSeller("AIR PRO 120", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/nikestore/small_shoe4.png", "4.9", "$300","COOL");
        BestSeller i5 = new BestSeller("NIKE MAX", "https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/nikestore/small_shoe5.png", "4.4", "$120","MAX");
        bestSellerList.add(i1);
        bestSellerList.add(i2);
        bestSellerList.add(i3);
        bestSellerList.add(i4);
        bestSellerList.add(i5);
        setBestSellerRecycler(bestSellerList);
        cart = findViewById(R.id.big_shoe_cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ProductDetails.class);
            }
        });
    }

    private void setUserRecycler(List<NewRelease> newReleaseList){
        recyclerView = findViewById(R.id.recyclerViewId);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        releaseRecyclerAdapter = new NewReleaseRecyclerAdapter(this , newReleaseList);
        recyclerView.setAdapter(releaseRecyclerAdapter);
    }
    private void setBestSellerRecycler(List<BestSeller> bestSellerList)
    {
        recyclerView = findViewById(R.id.bestSellerRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        bestSellerAdapter = new BestSellerAdapter(this , bestSellerList);
        recyclerView.setAdapter(bestSellerAdapter);

    }
}