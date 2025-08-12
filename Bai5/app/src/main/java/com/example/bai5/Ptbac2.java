package com.example.bai5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ptbac2 extends AppCompatActivity {

    EditText editA, editB, editC;
    Button btnTiepTuc, btnGiaiPT, btnThoat;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptbac2);

        editA = findViewById(R.id.editA);
        editB = findViewById(R.id.editB);
        editC = findViewById(R.id.editC);
        btnTiepTuc = findViewById(R.id.btnTiepTuc);
        btnGiaiPT = findViewById(R.id.btnGiaiPT);
        btnThoat = findViewById(R.id.btnThoat);
        txtKetQua = findViewById(R.id.txtKetQua);

        // Nút Tiếp tục
        btnTiepTuc.setOnClickListener(v -> {
            editA.setText("");
            editB.setText("");
            editC.setText("");
            txtKetQua.setText("");
            editA.requestFocus();
        });

        // Nút Giải PT
        btnGiaiPT.setOnClickListener(v -> {
            try {
                double a = Double.parseDouble(editA.getText().toString());
                double b = Double.parseDouble(editB.getText().toString());
                double c = Double.parseDouble(editC.getText().toString());

                if (a == 0) {
                    if (b == 0) {
                        txtKetQua.setText(c == 0 ? "Vô số nghiệm" : "Vô nghiệm");
                    } else {
                        txtKetQua.setText("Nghiệm: x = " + (-c / b));
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        txtKetQua.setText("Vô nghiệm");
                    } else if (delta == 0) {
                        txtKetQua.setText("Nghiệm kép: x = " + (-b / (2 * a)));
                    } else {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        txtKetQua.setText("x1 = " + x1 + "; x2 = " + x2);
                    }
                }
            } catch (Exception e) {
                txtKetQua.setText("Vui lòng nhập đầy đủ và đúng dữ liệu");
            }
        });

        // Nút Thoát
        btnThoat.setOnClickListener(v -> finish());
    }
}
