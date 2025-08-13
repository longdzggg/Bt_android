package com.example.bai9;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Build;

import android.view.View;
import android.widget.ImageButton;

import androidx.core.content.ContextCompat;

import intent_service.MyService;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnPlay, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.imgstart);
        btnStop = findViewById(R.id.imgstop);

        Intent serviceIntent = new Intent(this, MyService.class);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Bắt đầu Service (O+ nên dùng startForegroundService)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    ContextCompat.startForegroundService(MainActivity.this, serviceIntent);
                } else {
                    startService(serviceIntent);
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(serviceIntent);
            }
        });
    }
}
