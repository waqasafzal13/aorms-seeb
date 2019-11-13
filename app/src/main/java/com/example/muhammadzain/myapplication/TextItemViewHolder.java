package com.example.muhammadzain.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class TextItemViewHolder extends RecyclerView.ViewHolder {
    private TextView dishes;
    private TextView prices;


    public TextItemViewHolder(View itemView) {
        super(itemView);
        dishes = (TextView) itemView.findViewById(R.id.name);
        prices = itemView.findViewById(R.id.price);
    }

    public void bind(String dish, String price) {
        dishes.setText(dish);
        prices.setText(price);
    }

}
