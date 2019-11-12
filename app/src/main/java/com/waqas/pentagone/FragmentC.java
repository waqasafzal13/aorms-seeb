package com.example.android.seproject;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FragmentC extends Fragment {

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

        String[] dishes = getResources().getStringArray(R.array.chinese_dishes);
        String[] prices = getResources().getStringArray(R.array.chinese_prices);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(dishes, prices,calltoparent);
        imageView = view.findViewById(R.id.img);
        imageView.setImageResource(R.drawable.chinese);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}