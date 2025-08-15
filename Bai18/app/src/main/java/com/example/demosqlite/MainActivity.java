package com.example.demosqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editId;
    Button btnAdd, btnView, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.editName);
        editId = findViewById(R.id.editId);
        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        btnDelete = findViewById(R.id.btnDelete);

        addData();
        viewAll();
        deleteData();
    }

    public void addData() {
        btnAdd.setOnClickListener(v -> {
            boolean inserted = myDb.insertStudent(editName.getText().toString());
            Toast.makeText(this, inserted ? "Đã thêm" : "Lỗi thêm", Toast.LENGTH_SHORT).show();
        });
    }

    public void viewAll() {
        btnView.setOnClickListener(v -> {
            Cursor res = myDb.getAllStudents();
            if (res.getCount() == 0) {
                showMessage("Lỗi", "Không có dữ liệu");
                return;
            }

            StringBuilder buffer = new StringBuilder();
            while (res.moveToNext()) {
                buffer.append("ID: ").append(res.getInt(0)).append("\n");
                buffer.append("Tên: ").append(res.getString(1)).append("\n\n");
            }
            showMessage("Danh sách", buffer.toString());
        });
    }

    public void deleteData() {
        btnDelete.setOnClickListener(v -> {
            int deletedRows = myDb.deleteStudent(Integer.parseInt(editId.getText().toString()));
            Toast.makeText(this, deletedRows > 0 ? "Đã xóa" : "Không tìm thấy ID", Toast.LENGTH_SHORT).show();
        });
    }

    public void showMessage(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .show();
    }
}
