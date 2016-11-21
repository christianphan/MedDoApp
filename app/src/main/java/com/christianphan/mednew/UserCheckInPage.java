package com.christianphan.mednew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by chris on 11/19/16.
 */

public class UserCheckInPage extends AppCompatActivity {

    int total = 5;
    int checked = 0;
    int arraycurrent= 0;
    int[] startingarray = new int[total];
    Bundle b = new Bundle();
    String name = "'";

    String[] arrayone = new String[total];
    String[] arraytwo = new String[total];
    String[] arraythree = new String[total];
    String[] arrayfour = new String[total];
    String[] arrayfive = new String[total];


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usercheckon);


        for(int i = 0; i < 5; i ++){
            startingarray[i] = 0;
        }

        for(int i = 0; i < 5; i ++){
            arrayone[i] = "";
        }

        for(int i = 0; i < 5; i ++){
            arraytwo[i] = "";
        }

        for(int i = 0; i < 5; i ++){
            arraythree[i] = "";
        }

        for(int i = 0; i < 5; i ++){
            arrayfour[i] = "";
        }

        for(int i = 0; i < 5; i ++){
            arrayfive[i] = "";
        }


        final CheckBox checkone = (CheckBox) findViewById(R.id.checkone);
        final CheckBox checktwo = (CheckBox) findViewById(R.id.checktwo);
        final CheckBox checkthree = (CheckBox) findViewById(R.id.checkthree);
        final CheckBox checkfour = (CheckBox) findViewById(R.id.checkFour);
        final CheckBox checkfive = (CheckBox) findViewById(R.id.checkFive);
        Button button = (Button) findViewById(R.id.GoToCharts);
        Button button2 = (Button) findViewById(R.id.update);


        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("Name");



        Log.w("myApp", name + "test");

        if(name.contains("Chronic Obstructive Pulmonary Disease"))
        {
            Log.w("myApp", "Changed");
            checkone.setText("Eat Healthy Breakfast");
            checktwo.setText("Eat Healthy Lunch");
            checkthree.setText("Eat a mederiterranean diet");
            checkfour.setText("Focus on smoking cessation");
            checkfive.setText("Manage stress");
        }

        if(name.contains("Type 2 Diabetes"))
        {
            checkone.setText("Take metaormin oral medication after meals");
            checktwo.setText("Eat a low sugar lunch");
            checkthree.setText("Inject insulin before bed");
            checkfour.setText("Eat a low sugar dinner");
            checkfive.setText("Check blood sugar level");
        }

        if(name.contains("High Cholesterol"))
        {
            checkone.setText("Take Cholesterol medication");
            checktwo.setText("Excercise 30-60 min");
            checkthree.setText("Daily calories less than 25% fat");
            checkfour.setText("Eat fruits/vegetables");
            checkfive.setText("Eat low-fat and low-salt meals");
        }

        if(name.contains("Hypertension"))
        {
            checkone.setText("Take blood pressure medicine");
            checktwo.setText("Excercise for 30 min");
            checkthree.setText("Check blood pressure");
            checkfour.setText("Manage stress");
            checkfive.setText("Limit salt intake to 2000-3000 mg a day");
        }




        checkone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(checkone.isChecked()){

                    checked++;

                }else{

                    checked--;

                }
            }
        });


        checktwo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(checktwo.isChecked()){

                    checked++;

                }else{

                    checked--;

                }
            }
        });



        checkthree.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(checkthree.isChecked()){

                    checked++;

                }else{

                    checked--;

                }
            }
        });

        checkfour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(checkfour.isChecked()){

                    checked++;

                }else{

                    checked--;

                }
            }
        });

        checkfive.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(checkfive.isChecked()){

                    checked++;

                }else{

                    checked--;

                }
            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Log.w("myApp", "arraycurrent" + arraycurrent);
                Log.w("myAdd", Integer.toString(checked) + "checked");
                if(arraycurrent < 5)
                {
                    startingarray[arraycurrent] = checked;
                }
                checked = 0;

                if(checkone.isChecked())
                {
                    if(arraycurrent < 5)
                    {
                        arrayone[arraycurrent] = checkone.getText().toString();
                    }

                    checkone.toggle();
                }

                if(checktwo.isChecked())
                {

                    if(arraycurrent < 5)
                    {
                        arraytwo[arraycurrent] = checktwo.getText().toString();
                    }

                    checktwo.toggle();
                }


                if(checkthree.isChecked())
                {

                    if(arraycurrent < 5)
                    {
                        arraythree[arraycurrent] = checkthree.getText().toString();
                    }

                    checkthree.toggle();
                }


                if(checkfour.isChecked())
                {

                    if(arraycurrent < 5)
                    {
                        arrayfour[arraycurrent] = checkfour.getText().toString();
                    }

                    checkfour.toggle();
                }

                if(checkfive.isChecked())
                {

                    if(arraycurrent < 5)
                    {
                        arrayfive[arraycurrent] = checkfive.getText().toString();
                    }

                    checkfive.toggle();
                }
                arraycurrent++;


            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                b.putIntArray("Amount", startingarray);
                b.putStringArray("First", arrayone);
                b.putStringArray("Second", arraytwo);
                b.putStringArray("Third", arraythree);
                b.putStringArray("Fourth", arrayfour);
                b.putStringArray("Fifth", arrayfive);

                Intent i = new Intent(UserCheckInPage.this, GraphActivity.class);
                i.putExtras(b);

                startActivity(i);

            }
        });



    }

}
