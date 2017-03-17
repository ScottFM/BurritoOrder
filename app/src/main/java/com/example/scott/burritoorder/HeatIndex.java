package com.example.scott.burritoorder;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Scott on 3/16/2017.
 */

public class HeatIndex extends LinearLayout implements View.OnClickListener {
    Button bDown;
    Button bUp;
    LinearLayout ll;
    int heatIndex;
    TextView display;

    private Context mContext;

    public HeatIndex(Context context) {
        super(context);
        initializeViews(context);
    }

    public HeatIndex(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public HeatIndex(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        mContext = context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.heatindex, this);

        bDown = (Button) findViewById(R.id.btnDown);
        bDown.setOnClickListener(this);

        bUp = (Button) findViewById(R.id.btnUp);
        bUp.setOnClickListener(this);

        ll = (LinearLayout) findViewById(R.id.ll2);
        display = (TextView) findViewById(R.id.txtHeat);
        heatIndex = 1;

        displayHeat();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDown:
                backDown();
                break;
            case R.id.btnUp:
                ampUp();
                break;
        }
    }

    public void backDown() {
        if (heatIndex > 1) {
            heatIndex--;
            displayHeat();
        }
    }

    public void ampUp() {
        if (heatIndex < 15) {
            heatIndex++;
            displayHeat();
        }
    }

    public void displayHeat() {
        ll.removeAllViews();
        for (int i = 0; i < heatIndex; i ++) {
            ImageView flame;
            flame = new ImageView(mContext);
            flame.setBackgroundResource(R.drawable.flameclipart);
            ll.addView(flame,100,100);
        }

        switch (heatIndex) {
            case 1:
                display.setText("Mild");
                ll.setBackgroundColor(Color.GREEN);
                display.setTextColor(Color.GREEN);
                break;
            case 2:
                display.setText("Mild-medium");
                ll.setBackgroundColor(Color.GREEN);
                display.setTextColor(Color.GREEN);
                break;
            case 3:
                display.setText("Medium");
                ll.setBackgroundColor(Color.YELLOW);
                display.setTextColor(Color.YELLOW);
                break;
            case 4:
                display.setText("Medium-hot");
                ll.setBackgroundColor(Color.YELLOW);
                display.setTextColor(Color.YELLOW);
                break;
            case 5:
                display.setText("Hot");
                ll.setBackgroundColor(Color.YELLOW);
                display.setTextColor(Color.YELLOW);
                break;
            case 6:
                display.setText("Blazin'");
                ll.setBackgroundColor(Color.RED);
                display.setTextColor(Color.RED);
                break;
            case 7:
                display.setText("Hellacious");
                ll.setBackgroundColor(Color.RED);
                display.setTextColor(Color.RED);
                break;
            default:
                display.setText("TOO HOT!");
                ll.setBackgroundColor(Color.RED);
                display.setTextColor(Color.RED);
                break;
        }
    }

    public int getHeat() {
        return heatIndex;
    }

}
