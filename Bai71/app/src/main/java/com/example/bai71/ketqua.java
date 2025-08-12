package com.example.bai71;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ketqua extends AppCompatActivity {

    TextView txtketqua;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ketqua);

        txtketqua = findViewById(R.id.txtketqua);
        btnBack = findViewById(R.id.btnBack);

        // Nhận dữ liệu
        Intent intent = getIntent();
        double a = intent.getDoubleExtra("soa", 0);
        double b = intent.getDoubleExtra("sob", 0);

        String result;

        if (a == 0) {
            if (b == 0) {
                result = "Phương trình vô số nghiệm";
            } else {
                result = "Phương trình vô nghiệm";
            }
        } else {
            double x = -b / a;
            result = "Nghiệm x = " + x;
        }

        txtketqua.setText(result);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay lại MainActivity
                Intent intent = new Intent(ketqua.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
