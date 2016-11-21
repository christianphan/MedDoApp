package com.christianphan.mednew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Handler;


public class ListOfActivities extends AppCompatActivity {

    ArrayList<ActivityItem> current_items;
    ActivityDataBase DB2;
    String first = "";
    String last = "";
    String items = "";
    String id = "";
    int intid;
    ArrayList<ActivityItem> list = new ArrayList<ActivityItem>();
    custom_adapter adapter;
    TextView text;
    Activity mActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofactivities_layout);
        text = (TextView) findViewById(R.id.text);
        DB2 = new ActivityDataBase(this);

        Bundle bundle = getIntent().getExtras();
        first = bundle.getString("First");
        last = bundle.getString("Last");
        id = bundle.getString("Other");
        intid = Integer.parseInt(id);

        Log.w("myApp", "Before2");

        if(FillItems() == true)
        {
            Log.w("myApp", "Parse");
            ParseString(items);
        }

        RecyclerView currentActivities = (RecyclerView) findViewById(R.id.activitylist);
        Button button = (Button) findViewById(R.id.add);

        button.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View v) {
                                          add();
                                      }
                                  });

        current_items = list;

        adapter = new custom_adapter(this, current_items);

        currentActivities.setAdapter(adapter);
        currentActivities.setLayoutManager(new LinearLayoutManager(this));

    }



    public boolean FillItems()
    {
        Cursor res = DB2.getAllData();


        if (res.getCount() == 0) {
            return false;
        }

        while (res.moveToNext()) {
            if(res.getString(1).contains(first + last))
            {
                items = res.getString(2);
                return true;
            }
        }
        return false;


    }

    public void ParseString(String listitems)
    {
        //splits up string divided by commas
        String[] strValues = listitems.split(",");

        //turns the array of strings into an arraylist
        ArrayList<String> aList = new ArrayList<String>(Arrays.asList(strValues));

        for(int i = 0; i < aList.size(); i ++) {
            String testvalue = "";
            testvalue = aList.get(i);
            Log.w("myApp", testvalue);

            createList(testvalue);

        }


    }

    public void createList(String listname)
    {
        if(listname.contains("Chronic Obstructive Pulmonary Disease"))
        {
            String[] checklist = {"Eat Healthy Breakfast", "Eat Healthy Lunch", "Excercize for 30-60 min", "Have Healthy Dinner", "Use Medication"};
            ActivityItem newItem = new ActivityItem(listname, checklist);
            list.add(newItem);
        }
        if(listname.contains("Type 2 Diabetes"))
        {
            String[] checklist = {"Eat Healthy Breakfast", "Eat Healthy Lunch", "Excercize for 30-60 min", "Have Healthy Dinner", "Use Medication"};
            ActivityItem newItem = new ActivityItem(listname, checklist);
            list.add(newItem);
        }
        if(listname.contains("Hypertension"))
        {
            String[] checklist = {"Eat Healthy Breakfast", "Eat Healthy Lunch", "Excercize for 30-60 min", "Have Healthy Dinner", "Use Medication"};
            ActivityItem newItem = new ActivityItem(listname, checklist);
            list.add(newItem);
        }
        if(listname.contains("High Cholesterol"))
        {
            String[] checklist = {"Eat Healthy Breakfast", "Eat Healthy Lunch", "Excercize for 30-60 min", "Have Healthy Dinner", "Use Medication"};
            ActivityItem newItem = new ActivityItem(listname, checklist);
            list.add(newItem);
        }



    }

    public void add()
    {
        Log.w("myApp", "Created");

        final AlertDialog.Builder builder = new AlertDialog.Builder(ListOfActivities.this);
        final AlertDialog OptionDialog = builder.create();
        OptionDialog.setTitle("Choose Plan" );
        LayoutInflater inflater = getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.addplans, null);
        OptionDialog.setView(dialoglayout);
        OptionDialog.show();


        TextView text1 = (TextView) dialoglayout.findViewById(R.id.item1);
        TextView text2 = (TextView) dialoglayout.findViewById(R.id.item2);
        TextView text3 = (TextView) dialoglayout.findViewById(R.id.item3);
        TextView text4 = (TextView) dialoglayout.findViewById(R.id.item4);

        text1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String[] checklist = {"Eat Healthy Breakfast", "Eat Healthy Lunch", "Excercize for 30-60 min", "Have Healthy Dinner", "Use Medication"};
                ActivityItem newItem = new ActivityItem("Chronic Obstructive Pulmonary Disease", checklist);
                list.add(newItem);

                Cursor res = DB2.getAllData();
                Log.w("myApp", "1");


                while (res.moveToNext()) {
                    Log.w("myApp", "1.2");

                    if (res.getString(1).contains(first + last)) {
                        Log.w("myApp", "3");

                        items = res.getString(2);
                        items += "," + "Chronic Obstructive Pulmonary Disease";
                        DB2.updateData(id,items);
                        Log.w("myApp", "4");
                        adapter.notifyDataSetChanged();
                        OptionDialog.cancel();
                    }
                }


            }

        });



        text2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String[] checklist = {"Eat Healthy Breakfast", "Eat Healthy Lunch", "Excercize for 30-60 min", "Have Healthy Dinner", "Use Medication"};
                ActivityItem newItem = new ActivityItem("Type 2 Diabetes", checklist);
                list.add(newItem);

                Cursor res = DB2.getAllData();
                Log.w("myApp", "1");


                while (res.moveToNext()) {
                    Log.w("myApp", "1.2");

                    if (res.getString(1).contains(first + last)) {
                        Log.w("myApp", "3");

                        items = res.getString(2);
                        items += "," + "Type 2 Diabetes";
                        DB2.updateData(id,items);
                        Log.w("myApp", "4");
                        adapter.notifyDataSetChanged();
                        OptionDialog.cancel();
                    }
                }


            }

        });



        text3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String[] checklist = {"Eat Healthy Breakfast", "Eat Healthy Lunch", "Excercize for 30-60 min", "Have Healthy Dinner", "Use Medication"};
                ActivityItem newItem = new ActivityItem("High Cholesterol", checklist);
                list.add(newItem);

                Cursor res = DB2.getAllData();
                Log.w("myApp", "1");


                while (res.moveToNext()) {
                    Log.w("myApp", "1.2");

                    if (res.getString(1).contains(first + last)) {
                        Log.w("myApp", "3");

                        items = res.getString(2);
                        items += "," + "High Cholesterol";
                        DB2.updateData(id,items);
                        Log.w("myApp", "4");
                        adapter.notifyDataSetChanged();
                        OptionDialog.cancel();
                    }
                }


            }

        });



        text4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String[] checklist = {"Eat Healthy Breakfast", "Eat Healthy Lunch", "Excercize for 30-60 min", "Have Healthy Dinner", "Use Medication"};
                ActivityItem newItem = new ActivityItem("Hypertension", checklist);
                list.add(newItem);

                Cursor res = DB2.getAllData();
                Log.w("myApp", "1");


                while (res.moveToNext()) {
                    Log.w("myApp", "1.2");

                    if (res.getString(1).contains(first + last)) {
                        Log.w("myApp", "3");

                        items = res.getString(2);
                        items += "," + "Hypertension";
                        DB2.updateData(id,items);
                        Log.w("myApp", "4");
                        adapter.notifyDataSetChanged();
                        OptionDialog.cancel();
                    }
                }


            }

        });





    }


    public void fillolddata(String newitem)
    {

    }



}

