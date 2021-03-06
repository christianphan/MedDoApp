package com.christianphan.mednew;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by chris on 11/20/16.
 */

public class GraphActivity extends AppCompatActivity {

    String[] entries = new String[5];
    String emailbody = "";
    int listsize = 0;
    int daysize = 0;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_layout);

        Log.w("myApp", "1");
        Bundle bundle = getIntent().getExtras();
        int[] list = bundle.getIntArray("Amount");
        String[] first = bundle.getStringArray("First");
        String[] second = bundle.getStringArray("Second");
        String[] third = bundle.getStringArray("Third");
        String[] fourth = bundle.getStringArray("Fourth");
        String[] fifth = bundle.getStringArray("Fifth");
        name = bundle.getString("Name");


        for (int i = 0; i < 5; i++) {
            if (list[i] != 0) {
                listsize++;
            }
        }
        daysize = listsize - 1;

        if (listsize > 0) {
            emailbody += "Objectives completed " + Integer.toString(daysize) + " days ago: ";
            listsize--;


            if(first[0] != "")
            {
                emailbody += first[0] + " ";
            }
            if(second[0] != "")
            {
                emailbody += second[0] + " ";

            }
            if(third[0] != "")
            {
                emailbody += third[0] + " ";
            }
            if(fourth[0] != "")
            {
                emailbody += fourth[0] + " ";
            }
            if(fifth[0] != "")
            {
                emailbody += fifth[0] + " ";
            }
        }


        daysize = listsize - 1;

        if (listsize > 0) {
            emailbody += ". Objectives completed " + Integer.toString(daysize) + " days ago: ";
            listsize--;

            if(first[0] != "")
            {
                emailbody += first[1] + " ";
            }
            if(second[0] != "")
            {
                emailbody += second[1] + " ";

            }
            if(third[0] != "")
            {
                emailbody += third[1] + " ";
            }
            if(fourth[0] != "")
            {
                emailbody += fourth[1] + " ";
            }
            if(fifth[0] != "")
            {
                emailbody += fifth[1] + " ";
            }


        }




        daysize = listsize - 1;

        if (listsize > 0) {
            emailbody += ". Objectives completed " + Integer.toString(daysize) + " days ago: ";
            listsize--;
            if(first[0] != "")
            {
                emailbody += first[2] + " ";
            }
            if(second[0] != "")
            {
                emailbody += second[2] + " ";

            }
            if(third[0] != "")
            {
                emailbody += third[2] + " ";
            }
            if(fourth[0] != "")
            {
                emailbody += fourth[2] + " ";
            }
            if(fifth[0] != "")
            {
                emailbody += fifth[2] + " ";
            }
        }




            daysize = listsize -1;
            if(listsize > 0)
            {
                emailbody +=  ". Objectives completed " + Integer.toString(daysize)  + " days ago: ";
                listsize--;
                if(first[0] != "")
                {
                    emailbody += first[3] + " ";
                }
                if(second[0] != "")
                {
                    emailbody += second[3] + " ";

                }
                if(third[0] != "")
                {
                    emailbody += third[3] + " ";
                }
                if(fourth[0] != "")
                {
                    emailbody += fourth[3] + " ";
                }
                if(fifth[0] != "")
                {
                    emailbody += fifth[3] + " ";
                }
            }



            daysize = listsize -1;

            if(listsize > 0)
            {
                emailbody +=  ". Objectives completed " + Integer.toString(daysize)  + " days ago: ";
                listsize--;

                if(first[0] != "")
                {
                    emailbody += first[4] + " ";
                }
                if(second[0] != "")
                {
                    emailbody += second[4] + " ";

                }
                if(third[0] != "")
                {
                    emailbody += third[4] + " ";
                }
                if(fourth[0] != "")
                {
                    emailbody += fourth[4] + " ";
                }
                if(fifth[0] != "")
                {
                    emailbody += fifth[4] + " ";
                }
            }





        Log.w("myApp", "2");
        for(int i = 0; i < 5 ; i++)
        {
            entries[i] = Integer.toString(list[i]) + "f";
        }

        final BarChart chart = (BarChart) findViewById(R.id.barchart);
        Button send = (Button)   findViewById(R.id.send);



        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                isStoragePermissionGranted();
                chart.saveToGallery("GraphReport", 10);

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"shakingwater@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Weekly Status Report: " + name);
                i.putExtra(Intent.EXTRA_TEXT   , emailbody);
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                }

            }
        });

        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.setPinchZoom(false);
        chart.setDrawGridBackground(false);

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        Log.w("myAdd", Integer.toString(list[0]) + "list[0]");
        Log.w("myAdd", Integer.toString(list[1]) + "list[1]");
        Log.w("myAdd", Integer.toString(list[2]) + "list[2]");
        Log.w("myAdd", Integer.toString(list[3]) + "list[3]");

        Log.w("myApp", "3");
        barEntries.add((new BarEntry(0f,list[0])));
        barEntries.add((new BarEntry(1f,list[1])));
        barEntries.add((new BarEntry( 2f, list[2])));
        barEntries.add((new BarEntry(3f,list[3])));
        barEntries.add((new BarEntry(4f,list[4])));

        BarDataSet set = new BarDataSet(barEntries, "Completed");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        set.setValues(barEntries);


        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set);

        BarData data = new BarData(dataSets);
        data.setValueTextSize(10f);
        data.setBarWidth(0.9f);



        Log.w("myApp", "4");
        ArrayList<String> Dates = new ArrayList<>();
        Dates.add("4 days ago");
        Dates.add("3 days ago");
        Dates.add("2 days ago");
        Dates.add("1 days ago");
        Dates.add("Today");

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setAxisMinimum(0f);
        rightAxis.setAxisMaximum(5f);
        rightAxis.setLabelCount(1);



        Log.w("myApp", "6");
        chart.setData(data);



}




    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.w("APP","Permission is granted");
                return true;
            } else {

                Log.w("APP","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 225);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.w("APP","Permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.w("APP","Permission: "+permissions[0]+ "was "+grantResults[0]);
            //resume tasks needing this permission
        }
    }



}
