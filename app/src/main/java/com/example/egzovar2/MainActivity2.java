package com.example.egzovar2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity2 extends AppCompatActivity {

    RelativeLayout relativeLayout;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        relativeLayout = findViewById(R.id.relativeLayout);
        relativeLayout.setBackgroundColor(Color.RED);

        button1 = findViewById(R.id.button2);
        button2 = findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MyBroadcastReceiver.mp != null) {
                    MyBroadcastReceiver.mp.stop();
                    MyBroadcastReceiver.mp.release();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
}