package com.example.android.seproject;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class confirmorder extends AppCompatActivity {

    private RecyclerView mOrderlistrx;
    private Button mConfirmbtn;
    private ArrayList<String> dishname;
    private ArrayList<String>dishprice;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmorder);
        Intent old = getIntent();
      dishname = old.getStringArrayListExtra("dishname");
      dishprice= old.getStringArrayListExtra("dishprice");
        initView();
    }

    private void initView()
    {
        mOrderlistrx = (RecyclerView) findViewById(R.id.orderlistrx);
        mOrderlistrx.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        mOrderlistrx.setAdapter(adapter);
        mConfirmbtn = (Button) findViewById(R.id.confirmbtn);
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myholder> {


        Context c;
        public RecyclerViewAdapter(Context d)
        {
          this.c=d;
        }

        @Override
        public myholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.confirmorder_list_row, parent, false);
            return new myholder(view);
        }

        @Override
        public void onBindViewHolder(myholder holder, int position)
        {
            holder.dishes.setText(dishname.get(position));
            holder.prices.setText(dishprice.get(position));
            String[] items = new String[]{"1", "2", "3"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(c, android.R.layout.simple_spinner_dropdown_item, items);
            holder.spinner.setAdapter(adapter);
            holder.spinner.setSelection(0);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemCount() {
            return dishname.size();

        }

public class myholder extends RecyclerView.ViewHolder
{
    private TextView dishes;
    private TextView prices;
    private Spinner spinner;
    public myholder(@NonNull View itemView)
    {
        super(itemView);
        this.dishes = itemView.findViewById(R.id.dishname);
        this.prices = itemView.findViewById(R.id.dishprice);
        this.spinner= itemView.findViewById(R.id.quantity);
    }
}

    }



}
