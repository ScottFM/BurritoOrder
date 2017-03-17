package com.example.scott.burritoorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout llyt;
    Button add, checkout;
    private int numBurritoes;

    SharedPreferences sharedMeat;
    SharedPreferences.Editor editorMeat;
    SharedPreferences sharedHeat;
    SharedPreferences.Editor editorHeat;
    SharedPreferences sharedFixins;
    SharedPreferences.Editor editorFixins;

    ImageView burrito;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeViews();
        setOrder();
        createBurrito();
    }

    @Override
    public void onResume() {
        super.onResume();
        initializeViews();
        setOrder();
        createBurrito();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initializeViews() {
        llyt = (LinearLayout) findViewById(R.id.ll);

        //burrito = new ImageView(this);
        //burrito.setBackgroundResource(R.drawable.burrito);

        add = (Button) findViewById(R.id.btnAddBurrito);
        add.setOnClickListener(this);



        checkout = (Button)findViewById(R.id.btnCheckout);
        checkout.setOnClickListener(this);

        sharedMeat = getSharedPreferences("meat", 0);
        sharedHeat = getSharedPreferences("heat", 0);
        sharedFixins = getSharedPreferences("fixins", 0);
    }

    public void setOrder() {

        String meat = sharedMeat.getString("meat","default");
        String heat = sharedHeat.getString("heat", "default");
        Boolean rice = sharedFixins.getBoolean("rice", false);
        Boolean cheese = sharedFixins.getBoolean("cheese", false);
        Boolean cream = sharedFixins.getBoolean("cream", false);
        Boolean guac = sharedFixins.getBoolean("guac", false);
        Boolean queso = sharedFixins.getBoolean("queso", false);

        BurritoObject burrito = new BurritoObject(this);
        burrito.setHeat(heat); burrito.setMeat(meat); burrito.setRice(rice); burrito.setShreddedCheese(cheese); burrito.setSourCream(cream); burrito.setGuacamole(guac); burrito.setQueso(queso);
        llyt.removeAllViews();
        burrito.createBurrito(this);
        llyt.addView(burrito);

        //Toast.makeText(this, "cheese: " + cheese + " cream: " + cream + " guac: " + guac + " queso: " + queso + " rice: " + rice, Toast.LENGTH_LONG).show();
        //Toast.makeText(this, "heat: " + heat, Toast.LENGTH_SHORT).show();
    }

    public void createBurrito() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddBurrito:
                if (numBurritoes < 4) {
                    Intent I = new Intent("com.example.Scott.burritoorder.ChooseMeat");
                    finish();
                    startActivity(I);
                }
                break;

            case R.id.btnCheckout:
                break;
        }
    }
}
