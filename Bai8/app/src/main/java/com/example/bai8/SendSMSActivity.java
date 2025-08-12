package com.example.bai8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bai8.R;

public class SendSMSActivity extends AppCompatActivity {

    EditText edtSMS;
    ImageButton btnSMS;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_layout);

        edtSMS = findViewById(R.id.edtsms);
        btnSMS = findViewById(R.id.btnsms);
        btnBack = findViewById(R.id.btnback2);

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtSMS.getText().toString();
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone));
                smsIntent.putExtra("sms_body", "Hello from My_Contact app");
                startActivity(smsIntent);
            }
        });

        btnBack.setOnClickListener(view -> finish());
    }
}
