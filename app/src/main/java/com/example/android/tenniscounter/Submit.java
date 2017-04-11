package com.example.android.tenniscounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class Submit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        String[] arrayName = new String[2];

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            arrayName = extras.getStringArray("arrayName");
        }
            Log.v("Value of data var", arrayName[0]);
            Log.v("Value of data var", arrayName[1]);
    }
}
