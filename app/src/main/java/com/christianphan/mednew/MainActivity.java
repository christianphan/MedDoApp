package com.christianphan.mednew;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper myDB;
    ActivityDataBase DB2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DataBaseHelper(getApplicationContext());
        myDB.getAllData();
        DB2 = new ActivityDataBase(this);
        DB2.getAllData();

        Button button = (Button) findViewById(R.id.new_user);
        Button button2 = (Button) findViewById(R.id.login_button);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), Newuser_Login.class);
                startActivity(myIntent);
            }


        });



        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(myIntent);
            }


        });


    }



}
