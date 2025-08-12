package com.example.bai4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bai4.R;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtC, edtF;
    Button btnToC, btnToF, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtC = findViewById(R.id.edtC);
        edtF = findViewById(R.id.edtF);
        btnToC = findViewById(R.id.btnToC);
        btnToF = findViewById(R.id.btnToF);
        btnClear = findViewById(R.id.btnClear);

        DecimalFormat dcf = new DecimalFormat("#.00");

        btnToC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double f = Double.parseDouble(edtF.getText().toString());
                double c = (f - 32) / 1.8;
                edtC.setText(dcf.format(c));
            }
        });

        btnToF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double c = Double.parseDouble(edtC.getText().toString());
                double f = c * 1.8 + 32;
                edtF.setText(dcf.format(f));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtC.setText("");
                edtF.setText("");
            }
        });
    }
}
