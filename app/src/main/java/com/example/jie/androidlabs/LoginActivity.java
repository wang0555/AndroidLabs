package com.example.jie.androidlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.defaultValue;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LogintActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);




        Log.i(ACTIVITY_NAME, "In onCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "onStart()");

        Button login_Button = (Button)findViewById(R.id.Login_button);

        login_Button.setOnClickListener( new View.OnClickListener() {

            SharedPreferences prefs = getSharedPreferences("myLoginFileName", Context.MODE_PRIVATE);
            SharedPreferences.Editor myEditor = prefs.edit();
            EditText myLoginEmailName = (EditText)findViewById(R.id.editText_LonginName);

            @Override
            public void onClick(View view) {

                myEditor.putString("DefaultEmail",myLoginEmailName.getText().toString());
                myEditor.commit();

                Intent logninIntent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(logninIntent);
            }
        });

        SharedPreferences prefs = getSharedPreferences("myLoginFileName", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = prefs.edit();
        EditText myLoginEmailName = (EditText)findViewById(R.id.editText_LonginName);
        myLoginEmailName.setText(prefs.getString("DefaultEmail", "email@domain.com"));

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "onDestroy()");
    }

}
