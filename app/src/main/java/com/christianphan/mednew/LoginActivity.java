package com.christianphan.mednew;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by chris on 11/13/16.
 */
public class LoginActivity extends AppCompatActivity {

    DataBaseHelper myDB;
    String usernameall;
    String firstnameall;
    String indexall;
    String lastnameall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        myDB = new DataBaseHelper(this);


        Button submit = (Button) findViewById(R.id.login_button);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        TextView forgotpass = (TextView) findViewById(R.id.forgot);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                String username = editText.getText().toString();
                String password = editText2.getText().toString();

                if(checkinput(username,password) == true)
                {
                    Log.w("myApp", "true");

                    Bundle b = new Bundle();
                    b.putString("First", firstnameall);
                    b.putString("Last", lastnameall);
                    b.putString("Other", indexall);

                    Intent i = new Intent(LoginActivity.this, ListOfActivities.class);
                    i.putExtras(b);


                    Log.w("myApp", "Before");

                    startActivityForResult(i,1);

                }
                else
                {
                    Log.w("myApp", "false");

                    Toast toast = Toast.makeText(getApplicationContext(), "User Does Not Exit", Toast.LENGTH_LONG);
                    toast.show();

                }


            }
        });


        forgotpass.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {

            }
        });

    }


    public boolean checkinput(String username, String password)
    {
        Cursor res = myDB.getAllData();
        Log.w("myApp", "Read");


        if (res.getCount() == 0) {
            Log.w("myApp", "0");

            return false;
        }

        while (res.moveToNext()) {


            Log.w("myApp", res.getString(1));
            Log.w("myApp", res.getString(2));
            Log.w("myApp", password);

            Log.w("myApp", username);



            if(res.getString(1).matches(username) && res.getString(2).matches(password))
            {
                firstnameall = res.getString(4);
                Log.w("myApp", firstnameall);

                lastnameall = res.getString(5);
                Log.w("myApp", lastnameall);

                indexall = res.getString(6);
                Log.w("myApp", indexall);

                return true;
            }
        }
        return false;


    }


}