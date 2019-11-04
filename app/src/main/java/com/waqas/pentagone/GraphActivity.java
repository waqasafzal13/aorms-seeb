package com.waqas.pentagone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GraphActivity extends AppCompatActivity {

    private BarChart mBarChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        mBarChart=(BarChart)findViewById(R.id.graph);
        mBarChart.setScaleEnabled(false);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        List<BarEntry> barEntries=new ArrayList<>();
        for(int i=0;i<12;i++)
        {
            barEntries.add(new BarEntry(i,i));
        }

        BarDataSet barDataSet=new BarDataSet(barEntries,"Growth");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData barData=new BarData(barDataSet);
        barDataSet.setBarBorderWidth(1);

        mBarChart.setData(barData);
        mBarChart.setFitBars(true);

        Description description=new Description();
        description.setText("Daily Sales Report");
        mBarChart.setDescription(description);
        mBarChart.invalidate();
    }
}
