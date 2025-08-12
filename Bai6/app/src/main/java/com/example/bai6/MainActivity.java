package com.example.bai6;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtten, editCMND, editBosung;
    CheckBox chkdocbao, chkdocsach, chkdoccode;
    Button btnsend;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các control
        edtten = findViewById(R.id.edtten);
        editCMND = findViewById(R.id.edtcmnd);
        editBosung = findViewById(R.id.edtbosung);
        chkdocbao = findViewById(R.id.chkdocbao);
        chkdocsach = findViewById(R.id.chkdocsach);
        chkdoccode = findViewById(R.id.chkcode);
        btnsend = findViewById(R.id.btnsend);
        group = findViewById(R.id.idgruop);

        btnsend.setOnClickListener(v -> doShowInformation());

        // Đăng ký xử lý nút back bằng OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                showExitDialog();
            }
        });
    }

    private void doShowInformation() {
        // Kiểm tra tên
        String ten = edtten.getText().toString().trim();
        if (ten.length() < 3) {
            edtten.requestFocus();
            edtten.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        // Kiểm tra CMND
        String cmnd = editCMND.getText().toString().trim();
        if (cmnd.length() != 9) {
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        // Kiểm tra bằng cấp
        int id = group.getCheckedRadioButtonId();
        if (id == -1) {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad = findViewById(id);
        String bang = rad.getText().toString();

        // Kiểm tra sở thích
        StringBuilder sothich = new StringBuilder();
        if (chkdocbao.isChecked()) sothich.append(chkdocbao.getText()).append("\n");
        if (chkdocsach.isChecked()) sothich.append(chkdocsach.getText()).append("\n");
        if (chkdoccode.isChecked()) sothich.append(chkdoccode.getText()).append("\n");

        String bosung = editBosung.getText().toString();

        // Tạo AlertDialog hiển thị thông tin
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        String msg = ten + "\n" + cmnd + "\n" + bang + "\n" + sothich +
                "-----------------\n" +
                "Thông tin bổ sung:\n" + bosung + "\n-----------------";
        builder.setMessage(msg);
        builder.setPositiveButton("Đóng", (dialog, which) -> dialog.cancel());
        builder.create().show();
    }

    private void showExitDialog() {
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
        b.setIcon(android.R.drawable.ic_dialog_alert);
        b.setPositiveButton("Yes", (dialog, which) -> finish());
        b.setNegativeButton("No", (dialog, which) -> dialog.cancel());
        b.create().show();
    }
}
