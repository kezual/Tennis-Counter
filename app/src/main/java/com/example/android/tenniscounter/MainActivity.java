package com.example.android.tenniscounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View v){
        String[] arrayName = new String[2];
        Intent sub = new Intent(this, Submit.class);
        startActivity(sub);

        EditText p1 = (EditText) findViewById(R.id.player1);
        arrayName[0] = p1.getText().toString();

        EditText p2 = (EditText) findViewById(R.id.player2);
        arrayName[1] = p2.getText().toString();

        Intent value = new Intent(this, Submit.class);
        value.putExtra("arrayName", arrayName);
        startActivity(value);
    }
}
