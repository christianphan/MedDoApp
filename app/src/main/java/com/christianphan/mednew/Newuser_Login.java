package com.christianphan.mednew;


import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Newuser_Login extends AppCompatActivity {

    DataBaseHelper myDB;
    ActivityDataBase DB2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        myDB = new DataBaseHelper(this);
        DB2 = new ActivityDataBase(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_newuser_login);


        Button button = (Button) findViewById(R.id.Submit);
        final EditText editText = (EditText) findViewById(R.id.FirstName);
        final EditText editText2 = (EditText) findViewById(R.id.LastName);
        final EditText editText3 = (EditText) findViewById(R.id.Email);
        final EditText editText4 = (EditText) findViewById(R.id.password);
        final EditText editText5 = (EditText) findViewById(R.id.username);



        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String firstname = editText.getText().toString();
                String lastname = editText2.getText().toString();
                String email = editText3.getText().toString();
                String password = editText4.getText().toString();
                String username = editText5.getText().toString();

                if(firstname.matches("") || lastname.matches("") || email.matches("") || password.matches("") || username.matches("") )
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Fill Out All Entries", Toast.LENGTH_LONG);
                    toast.show();

                }
                else
                {
                    DB2.insertData(firstname + lastname, "");

                    Cursor res = DB2.getLastData();
                    String StringID = res.getString(0);

                    myDB.insertData(username,password,email,firstname,lastname, StringID);
                    Log.w("myApp", "no network");
                    finish();

                }
            }
        });


    }

}
