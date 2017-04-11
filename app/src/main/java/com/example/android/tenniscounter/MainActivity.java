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

        Intent sub = new Intent(this, Submit.class);
        startActivity(sub);

        EditText p1 = (EditText) findViewById(R.id.player1);
        String player1 = p1.getText().toString();

        EditText p2 = (EditText) findViewById(R.id.player2);
        String player2 = p1.getText().toString();

        Intent value = new Intent(this, Submit.class);
        value.putExtra("player1", player1);
        value.putExtra("player2", player2);
        startActivity(value);
    }
}
