package com.example.muhammadzain.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportPage extends AppCompatActivity {

    private Button dailySalesReport;
    private Button weeklySalesReport;
    private Button monthlySalesReport;
    private Button foodTypeReport;
    private Button inventoryReport;
    private Button dishTypeReport;
    private Button profitReport;
    private Intent i;
    private Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        i = new Intent(this, GraphActivity.class);
        logout = (Button) findViewById(R.id.logOut);
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Intent myIntent = new Intent(view.getContext(), agones.class);
                //startActivityForResult(myIntent, 0);


                final AlertDialog.Builder builder = new AlertDialog.Builder(ReportPage.this);

                builder.setMessage("this is message");
                builder.setTitle("RMS");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to logout from this application ?");
                //This will not allow to close dialogbox until user selects an option
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });

                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                //alert.setTitle("AlertDialogExample");
                alert.show();
            }

        });

        dailySalesReport = (Button) findViewById(R.id.first);
        dailySalesReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateDailySalesReport(i);
            }
        });
        weeklySalesReport = (Button) findViewById(R.id.second);
        weeklySalesReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateWeeklySalesReport(i);
            }
        });
        monthlySalesReport = (Button) findViewById(R.id.third);
        monthlySalesReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    generateMonthlySalesReport(i);
            }
        });
        foodTypeReport = (Button) findViewById(R.id.fourth);
        foodTypeReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    generateFoodTypeReport(i);
            }
        });
        inventoryReport = (Button) findViewById(R.id.fifth);
        inventoryReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    generateInventoryReport(i);
            }
        });
        dishTypeReport = (Button) findViewById(R.id.sixth);
        dishTypeReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    generateDishTypeReport(i);
            }
        });
        profitReport = (Button) findViewById(R.id.profit);
        profitReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    generateProfitReport(i);
            }
        });

    }

    public void generateDailySalesReport(Intent i) {
        startActivity(i);
    }

    public void generateWeeklySalesReport(Intent i) {
        startActivity(i);
    }

    public void generateMonthlySalesReport(Intent i) {
        startActivity(i);
    }

    public void generateFoodTypeReport(Intent i) {
        startActivity(i);
    }

    public void generateInventoryReport(Intent i) {
        startActivity(i);
    }

    public void generateDishTypeReport(Intent i) {
        startActivity(i);
    }

    public void generateProfitReport(Intent i) {
        startActivity(i);
    }

}
