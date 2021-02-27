package com.example.nikestore.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nikestore.ProductDetails;
import com.example.nikestore.R;
import com.example.nikestore.model.BestSeller;

import java.util.List;

public class BestSellerAdapter extends RecyclerView.Adapter<BestSellerAdapter.BestSellerHolder> {

    Context context;
    List<BestSeller> bestSellerList;

    public BestSellerAdapter(Context context, List<BestSeller> bestSellerList) {
        this.context = context;
        this.bestSellerList = bestSellerList;
    }
    @NonNull
    @Override
    public BestSellerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.best_seller_item, parent, false);
        return new BestSellerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellerHolder holder, int position) {
        holder.name.setText(bestSellerList.get(position).getName());
        holder.rating.setText(bestSellerList.get(position).getRating());
        holder.price.setText(bestSellerList.get(position).getPrice());
        holder.type.setText(bestSellerList.get(position).getType());
        Glide.with(context).load(bestSellerList.get(position).getImageUrl()).into(holder.nikeView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetails.class);
                intent.putExtra("name" , bestSellerList.get(position).getName());
                intent.putExtra("rating" , bestSellerList.get(position).getRating());
                intent.putExtra("price" , bestSellerList.get(position).getPrice());
                context.startActivity(intent);

            }
        });
    }
    @Override
    public int getItemCount() {
        return bestSellerList.size();
    }



    public static final class BestSellerHolder extends RecyclerView.ViewHolder {
        TextView price, name, rating;
        TextView type;
        ImageView nikeView;
        public BestSellerHolder(@NonNull View itemView) {
            super(itemView);
            nikeView = itemView.findViewById(R.id.shoe_image_id);
            price = itemView.findViewById(R.id.bestseller_price);
            name = itemView.findViewById(R.id.best_seller_price);
            rating = itemView.findViewById(R.id.rating);
            type = itemView.findViewById(R.id.best_seller_type);


        }
    }
}
