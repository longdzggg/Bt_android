package com.example.bai8;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.bai8.R;

public class CallPhoneActivity extends AppCompatActivity {

    EditText edtCall;
    ImageButton btnCall;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_layout);

        edtCall = findViewById(R.id.edtcall);
        btnCall = findViewById(R.id.btncallphone);
        btnBack = findViewById(R.id.btnback1);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtCall.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));

                if (ActivityCompat.checkSelfPermission(CallPhoneActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallPhoneActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(callIntent);
            }
        });

        btnBack.setOnClickListener(view -> finish());
    }
}
