package com.example.jie.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Log.i(ACTIVITY_NAME, "In onCreate()");

        Button start_Button = (Button) findViewById(R.id.startbutton);

        start_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(StartActivity.this, ListItemsActivity.class);
                startActivityForResult(startIntent, 5);
            }
        });
    }

   /* public void buttonClick( View whatWasClicked   )
    {
        Intent startIntent = new Intent(this, ListItemsActivity.class);
        startActivityForResult(startIntent,5);
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "onStart()");
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

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
         if(requestCode==5){
             Log.i(ACTIVITY_NAME,"Returned to StartActivity.onActivityResult");
         }
        if(resultCode== Activity.RESULT_OK){
            String messagePassed = data.getStringExtra("Response");
            Toast toast = Toast.makeText(StartActivity.this, messagePassed,Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
