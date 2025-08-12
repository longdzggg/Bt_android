package com.example.bai8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bai8.CallPhoneActivity;
import com.example.bai8.R;
import com.example.bai8.SendSMSActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCallPhone, btnSendSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCallPhone = findViewById(R.id.btncallphone);
        btnSendSMS = findViewById(R.id.btnsendsms);

        btnCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CallPhoneActivity.class);
                startActivity(intent);
            }
        });

        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SendSMSActivity.class);
                startActivity(intent);
            }
        });
    }
}
