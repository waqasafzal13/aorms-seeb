package com.example.android.seproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerViewAdapter extends RecyclerView.Adapter<TextItemViewHolder> {

    String[] dishes;
    String[] prices;
    FragmentA.selectedlist selectedlist;


    public RecyclerViewAdapter(String[] dishes, String[] prices,FragmentA.selectedlist obj)
    {
        this.dishes = dishes;
        this.prices = prices;
        selectedlist = obj;
    }

    @Override
    public TextItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_item, parent, false);
        return new TextItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TextItemViewHolder holder, final int position) {
        holder.bind(dishes[position], prices[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                selectedlist.addtolist(dishes[position],prices[position]);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return dishes.length;
    }



}
