package com.example.muhammadzain.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentB extends Fragment {



    RecyclerView recyclerView;
    ImageView imageView;
    FragmentA.selectedlist calltoparent;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentA.selectedlist)
        {
            calltoparent = (FragmentA.selectedlist) context;
        }

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment, container, false);
        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] dishes = getResources().getStringArray(R.array.cont_dishes);
        String[] prices = getResources().getStringArray(R.array.cont_prices);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(dishes,prices,calltoparent);
        imageView = view.findViewById(R.id.img);
        imageView.setImageResource(R.drawable.continental);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}