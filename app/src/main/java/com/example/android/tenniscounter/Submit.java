package com.example.android.tenniscounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Submit extends AppCompatActivity {

    String[] arrayName = new String[2];
    int pointA;
    int pointB;
    int gameA;
    int gameB;
    int setA;
    int setB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) {
            arrayName = extras.getStringArray("arrayName");
        }
        TextView player1 = (TextView) findViewById(R.id.firstPlayer);
        player1.setText(arrayName[0]);
        TextView player2 = (TextView) findViewById(R.id.secondPlayer);
        player2.setText(arrayName[1]);

        pointA = 0;
        pointB = 0;
        gameA = 0;
        gameB = 0;
        setA = 0;
        setB = 0;
    }

    public void displayPointA(int pointA){
        TextView point = (TextView) findViewById(R.id.pointA);
        switch (pointA){
            case 1:
                point.setText(String.valueOf(15));
                break;
            case 2:
                point.setText(String.valueOf(30));
                break;
            case 3:
                point.setText(String.valueOf(40));
                break;
        }
    }
    public void displayGameA(int gameA){
        TextView game = (TextView) findViewById(R.id.gameA);
        if(gameA <= 6 && gameB < 6){
            game.setText(String.valueOf(gameA));
        } else{
            if ((gameA - gameB) >= 2){
                setA = setA +1;
                displaySetA(setA);
                resetGames();
            }else{
                tieBreak();
            }
        }
    }
    public void tieBreak(){

    }
    public void displaySetA(int setA){
        TextView set = (TextView) findViewById(R.id.setA);
        if(setA <= 3){
            if((setA-setB) == 2){
                set.setText(String.valueOf(setA));
                //report
            } else{
                set.setText(String.valueOf(setA));
            }
        }
    }

    public void displayPointB(int pointB){
        TextView point = (TextView) findViewById(R.id.pointB);
        point.setText(String.valueOf(pointB));
    }

    public void increasePointA(View v){
        pointA = pointA + 1;
        if(pointA < 4) {
            displayPointA(pointA);
        } else{
            if ((pointA - pointB) == 0){
                displayPointB(3);
            }else if((pointA - pointB) == 1){
                TextView point = (TextView) findViewById(R.id.pointA);
                point.setText(String.valueOf("Adv"));
            } else if((pointA - pointB) >= 2){
                gameA = gameA + 1;
                displayGameA(gameA);
                resetPoints();
            }
        }
    }
    public void increasePointB(View v){
        pointB = pointB + 1;
        displayPointB(pointB);
    }

    public void resetPoints(){
        pointA = 0;
        pointB = 0;
        TextView pointPlayerA = (TextView) findViewById(R.id.pointA);
        pointPlayerA.setText(String.valueOf(pointA));
        TextView pointPlayerB = (TextView) findViewById(R.id.pointB);
        pointPlayerB.setText(String.valueOf(pointB));
    }
    public void resetGames(){
        gameA = 0;
        gameB = 0;
        TextView gamePlayerA = (TextView) findViewById(R.id.gameA);
        gamePlayerA.setText(String.valueOf(gameA));
        TextView gamePlayerB = (TextView) findViewById(R.id.gameB);
        gamePlayerB.setText(String.valueOf(gameB));
    }
}
