package com.example.muhammadzain.myapplication;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MUSA_RecyclerViewAdapter extends RecyclerView.Adapter<MUSA_TextItemViewHolder> {

    String[] dishes;
    String[] prices;
    MUSA_FragmentA.selectedlist selectedlist;


    public MUSA_RecyclerViewAdapter(String[] dishes, String[] prices, MUSA_FragmentA.selectedlist obj)
    {
        this.dishes = dishes;
        this.prices = prices;
        selectedlist = obj;
    }

    @Override
    public MUSA_TextItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.musa_menuitem_rowdesign, parent, false);
        return new MUSA_TextItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MUSA_TextItemViewHolder holder, final int position) {
        holder.bind(dishes[position], prices[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                int check =selectedlist.addtolist(dishes[position],prices[position]);
                if(check ==0)
                {
                    CardView card =  (CardView)holder.itemView;
                    card.setCardBackgroundColor(Color.argb(200,98,3,1));
                    //dish is selected
                }
                else
                {
                    CardView card =  (CardView)holder.itemView;
                    card.setCardBackgroundColor(Color.WHITE);
                    //dish is removed
                }
            }
        });

        int check =selectedlist.checktolist(dishes[position],prices[position]);
        if(check ==0)
        {
            CardView card =  (CardView)holder.itemView;
            card.setCardBackgroundColor(Color.argb(200,103,58,183));
            //dish is selected
        }
        else
        {
            CardView card =  (CardView)holder.itemView;
            card.setCardBackgroundColor(Color.WHITE);
            //dish is removed
        }

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
