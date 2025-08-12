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

public class MainActivity extends AppCompatActivity {

    EditText editNamDuong;
    Button btnChuyenDoi;
    TextView txtNamAm;

    String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
    String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNamDuong = findViewById(R.id.editNamDuong);
        btnChuyenDoi = findViewById(R.id.btnChuyenDoi);
        txtNamAm = findViewById(R.id.txtNamAm);

        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editNamDuong.getText().toString();
                if (input.isEmpty()) {
                    txtNamAm.setText("Vui lòng nhập năm dương");
                    return;
                }

                int namDuong = Integer.parseInt(input);
                String namAm = can[namDuong % 10] + " " + chi[namDuong % 12];
                txtNamAm.setText(namAm);
            }
        });
    }
}
