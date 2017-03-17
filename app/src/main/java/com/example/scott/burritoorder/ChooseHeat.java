package com.example.scott.burritoorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by Scott on 3/16/2017.
 */

public class ChooseHeat extends AppCompatActivity implements View.OnClickListener{

    HeatIndex heatIndex;
    Button cont;

    String heatString;

    SharedPreferences sharedHeat;
    SharedPreferences.Editor editorHeat;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseheat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeViews();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void initializeViews() {
        cont = (Button) findViewById(R.id.btnContinue2);
        cont.setOnClickListener(this);

        heatIndex = (HeatIndex) findViewById(R.id.heatIdx);

        sharedHeat = getSharedPreferences("heat", 0);
        editorHeat = sharedHeat.edit();
    }

    @Override
    public void onClick(View v) {
        int heat = heatIndex.getHeat();

        switch (heat) {
            case 1:
                heatString = "mild";
                break;
            case 2:
                heatString = "Mild-medium";
                break;
            case 3:
                heatString = "Medium";
                break;
            case 4:
                heatString = "Medium-hot";
                break;
            case 5:
                heatString = "Hot";
                break;
            case 6:
                heatString = "Blazin";
                break;
            case 7:
                heatString = "Hellacious";
                break;
            default:
                heatString = "TOO HOT!";
                break;
        }

        editorHeat.putString("heat", heatString);
        editorHeat.commit();

        Intent I = new Intent("com.example.Scott.burritoorder.ChooseFixins");
        finish();
        startActivity(I);
    }
}


