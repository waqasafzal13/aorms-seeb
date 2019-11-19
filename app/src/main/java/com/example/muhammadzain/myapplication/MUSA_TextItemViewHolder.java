package com.example.muhammadzain.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MUSA_TextItemViewHolder extends RecyclerView.ViewHolder {
    private TextView dishes;
    private TextView prices;


    public MUSA_TextItemViewHolder(View itemView) {
        super(itemView);
        dishes = (TextView) itemView.findViewById(R.id.dishnamex);
        prices = itemView.findViewById(R.id.dishpricex);
    }

    public void bind(String dish, String price) {
        dishes.setText(dish);
        prices.setText(price);
    }

}
