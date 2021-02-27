package com.example.nikestore.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nikestore.ProductDetails;
import com.example.nikestore.R;
import com.example.nikestore.model.NewRelease;

import java.util.List;

public class NewReleaseRecyclerAdapter extends RecyclerView.Adapter<NewReleaseRecyclerAdapter.NewReleaseViewHolder> {
    public NewReleaseRecyclerAdapter(Context context, List<NewRelease> newReleaseList) {
        this.context = context;
        this.newReleaseList = newReleaseList;
    }
    private final Context context;
    private final List<NewRelease> newReleaseList;
    @Override
    public NewReleaseViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.new_release_items, parent, false);
            return new NewReleaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewReleaseViewHolder holder, int position) {
        holder.shoeName.setText(newReleaseList.get(position).getName());
        holder.shoeGender.setText(newReleaseList.get(position).getGender());
        holder.shoePrice.setText(newReleaseList.get(position).getPrice());
        Glide.with(context).load(newReleaseList.get(position).getImageUrl()).into(holder.nikeView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetails.class);
                intent.putExtra("name" , newReleaseList.get(position).getName());
                intent.putExtra("price" , newReleaseList.get(position).getPrice());
                intent.putExtra("rating", newReleaseList.get(position).getRating());
                context.startActivity(intent);

            }
        });
    }
    @Override
    public int getItemCount() {
        return newReleaseList.size();
    }
    public static final class NewReleaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView shoePrice, shoeName, shoeGender;
        ImageView nikeView;
        public NewReleaseViewHolder( View itemView) {
            super(itemView);
            nikeView = itemView.findViewById(R.id.nike_view);
            shoePrice = itemView.findViewById(R.id.bestseller_price);
            shoeName = itemView.findViewById(R.id.shoe_name);
            shoeGender = itemView.findViewById(R.id.gender);
        }
        @Override
        public void onClick(View v) {
        }
    }

}
