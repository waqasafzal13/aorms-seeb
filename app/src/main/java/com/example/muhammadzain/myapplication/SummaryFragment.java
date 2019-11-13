package com.example.muhammadzain.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;



/**
 * A simple {@link Fragment} subclass.
 */
public class SummaryFragment extends Fragment {


    public SummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);

        View v = inflater.inflate(R.layout.fragment_summary, container, false);



        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_dashboard, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_dashboaard) {
            Toast.makeText(getActivity(), "Logout karwana", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getActivity(), MainActivity.class);
            getActivity().startActivity(i);
        }
        else if (item.getItemId() == R.id.back_home) {
            Intent i = new Intent(getActivity(), ListActivity.class);
            getActivity().startActivity(i);
        }
        return true;

    }
}
