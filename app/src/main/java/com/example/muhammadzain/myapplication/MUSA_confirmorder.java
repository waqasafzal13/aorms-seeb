package com.example.muhammadzain.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MUSA_confirmorder extends AppCompatActivity {

    private RecyclerView mOrderlistrx;
    private Button mConfirmbtn;
    private ArrayList<String> dishname;
    private ArrayList<String>dishprice;
    private ArrayList<String>quantityx;
    private TextView totalprice;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musa_confirmorder);
        Intent old = getIntent();
        dishname = old.getStringArrayListExtra("dishname");
        dishprice= old.getStringArrayListExtra("dishprice");
        quantityx = new ArrayList();
        initView();
    }

    private void initView()
    {
        mOrderlistrx = (RecyclerView) findViewById(R.id.orderlistrx);
        mOrderlistrx.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        mOrderlistrx.setAdapter(adapter);
        mConfirmbtn = (Button) findViewById(R.id.confirmbtn);
        mConfirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWaitingScreen();
            }
        });
        totalprice = findViewById(R.id.totalpricex);
    }

    private void openWaitingScreen(){
        Intent intent = new Intent(this, MUSA_waiting_screen.class);
        startActivity(intent);
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myholder> {


        Context c;
        public RecyclerViewAdapter(Context d)
        {
          this.c=d;
        }

        @Override
        public myholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.musa_confirmorder_list_row, parent, false);
            return new myholder(view);
        }

        @Override
        public void onBindViewHolder(final myholder holder, final int position)
        {
            holder.dishes.setText(dishname.get(position));
            holder.prices.setText(dishprice.get(position));

            if(quantityx.size()<=position)
            {
                quantityx.add(position,"1");
            }

            holder.qunatity.setText(quantityx.get(position));
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view)
                {

                    new AlertDialog.Builder(c)
                            .setTitle("Delete Dish")
                            .setMessage("Are you sure you want to delete this Dish?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    dishname.remove(position);
                                    dishprice.remove(position);
                                    quantityx.remove(position);
                                    notifyDataSetChanged();
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                    return true;
                }
            });

            holder.qunatity.setOnFocusChangeListener(new View.OnFocusChangeListener()
            {
                @Override
                public void onFocusChange(View v, boolean hasFocus)
                {
                    if (!hasFocus)
                    {
                        String val = holder.qunatity.getText().toString();
                        if(val.equals(""))
                        {
                            holder.qunatity.setText("1");
                            if(position<quantityx.size())
                            quantityx.remove(position);
                            quantityx.add(position,"1");
                            totalprice.setText("Total Price : "+String.valueOf(totalprice()));
                        }
                        else
                        {

                            //min check
                            int value = Integer.parseInt(val);
                            if(value<1)
                            {
                                value = 1;
                                holder.qunatity.setText(String.valueOf(value));
                                if(position<quantityx.size())
                                    quantityx.remove(position);
                                quantityx.add(position,String.valueOf(value));
                                totalprice.setText("Total Price : "+String.valueOf(totalprice()));
                            }
                        }
                    }
                }
            });


            holder.plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    String val = holder.qunatity.getText().toString();
                    int value = Integer.parseInt(val);

                    //max quantity check
                    value = value +1;
                    holder.qunatity.setText(String.valueOf(value));
                    if(position<quantityx.size())
                        quantityx.remove(position);                    quantityx.add(position,String.valueOf(value));
                    totalprice.setText("Total Price : "+String.valueOf(totalprice()));


                }
            });

            holder.minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    String val = holder.qunatity.getText().toString();
                    int value = Integer.parseInt(val);

                    //min quantity check
                    if(value>1)
                    {
                        value = value - 1;
                        holder.qunatity.setText(String.valueOf(value));
                        if(position<quantityx.size())
                            quantityx.remove(position);
                        quantityx.add(position,String.valueOf(value));
                        totalprice.setText("Total Price : "+String.valueOf(totalprice()));

                    }

                }
            });

            totalprice.setText("Total Price : "+String.valueOf(totalprice()));

        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemCount() {
            return dishname.size();

        }


        float totalprice()
        {

            float price =0;
            float val=0;
            float first =0;
            float second =0;
            for (int i =0;i<dishname.size();i++)
            {
                if(i<quantityx.size())
                {
                    first = Float.parseFloat(dishprice.get(i).replace("Rs ",""));
                    second= Float.parseFloat(quantityx.get(i));
                     val=  first* second ;
                }
                else
                {
                    first = Float.parseFloat(dishprice.get(i).replace("Rs ",""));
                     val = first * 1;
                }

                price += val;
            }
            return  price;
        }

public class myholder extends RecyclerView.ViewHolder
{
    private TextView dishes;
    private TextView prices;
    private TextView minus;
    private TextView plus;
    private EditText qunatity;
    public myholder(@NonNull View itemView)
    {
        super(itemView);
        this.dishes = itemView.findViewById(R.id.dishname);
        this.prices = itemView.findViewById(R.id.dishprice);
        this.minus = itemView.findViewById(R.id.minusquan);
        this.plus = itemView.findViewById(R.id.plusquan);
        this.qunatity = itemView.findViewById(R.id.qunatityedittext);


    }
}

    }



}
