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
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txta, txtb;
    Button btnketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txta = findViewById(R.id.txta);
        txtb = findViewById(R.id.txtb);
        btnketqua = findViewById(R.id.btnketqua);

        btnketqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(txta.getText().toString());
                double b = Double.parseDouble(txtb.getText().toString());

                Intent intent = new Intent(MainActivity.this, ketqua.class);
                intent.putExtra("soa", a);
                intent.putExtra("sob", b);
                startActivity(intent);
            }
        });
    }
}
