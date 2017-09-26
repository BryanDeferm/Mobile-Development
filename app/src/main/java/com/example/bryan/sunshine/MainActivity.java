package com.example.bryan.sunshine;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button ClickBtn, StartBtn;
    TextView ClickView, CountView;

    CountDownTimer timer;
    int time = 30;
    int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClickBtn = (Button) findViewById(R.id.CountBtn);
        ClickView = (TextView) findViewById(R.id.CountTxt);
        StartBtn = (Button) findViewById(R.id.StartBtn);
        CountView = (TextView) findViewById(R.id.TimeTxt);

        StartBtn.setEnabled(true);
        ClickBtn.setEnabled(false);

        timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                time--;
                CountView.setText("Time : " + time);
            }

            @Override
            public void onFinish() {
                StartBtn.setEnabled(false);
                ClickBtn.setEnabled(true);
            }
        };

        ClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicks++;
                ClickView.setText("Clicks : " + clicks);
            }
        });

        StartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
            }
        });
    }


}
