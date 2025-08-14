package com.example.qlsinhviensqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtmalop, edttenlop, edtsiso;
    Button btninsert, btndelete, btnupdate, btnquery;
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    SQLiteDatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtmalop = findViewById(R.id.edtmalop);
        edttenlop = findViewById(R.id.edttenlop);
        edtsiso = findViewById(R.id.edtsiso);
        btninsert = findViewById(R.id.btninsert);
        btndelete = findViewById(R.id.btndelete);
        btnupdate = findViewById(R.id.btnupdate);
        btnquery = findViewById(R.id.btnquery);

        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);

        // Tạo DB
        mydatabase = openOrCreateDatabase("qlsinhvien.db", MODE_PRIVATE, null);

        // Tạo bảng nếu chưa có
        try {
            String sql = "CREATE TABLE tbllop(malop TEXT primary key, tenlop TEXT, siso INTEGER)";
            mydatabase.execSQL(sql);
        } catch (Exception e) {
            Log.e("Error", "Table đã tồn tại");
        }

        // Nút INSERT
        btninsert.setOnClickListener(v -> {
            String malop = edtmalop.getText().toString();
            String tenlop = edttenlop.getText().toString();
            int siso = Integer.parseInt(edtsiso.getText().toString());

            ContentValues values = new ContentValues();
            values.put("malop", malop);
            values.put("tenlop", tenlop);
            values.put("siso", siso);

            String msg;
            if (mydatabase.insert("tbllop", null, values) == -1) {
                msg = "Fail to Insert Record!";
            } else {
                msg = "Insert record Successfully";
            }
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        });

        // Nút DELETE
        btndelete.setOnClickListener(v -> {
            String malop = edtmalop.getText().toString();
            int n = mydatabase.delete("tbllop", "malop = ?", new String[]{malop});
            String msg = (n == 0) ? "No record to Delete" : n + " record(s) deleted";
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        });

        // Nút UPDATE
        btnupdate.setOnClickListener(v -> {
            int siso = Integer.parseInt(edtsiso.getText().toString());
            String malop = edtmalop.getText().toString();

            ContentValues values = new ContentValues();
            values.put("siso", siso);

            int n = mydatabase.update("tbllop", values, "malop = ?", new String[]{malop});
            String msg = (n == 0) ? "No record to Update" : n + " record(s) updated";
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        });

        // Nút QUERY
        btnquery.setOnClickListener(v -> {
            mylist.clear();
            Cursor c = mydatabase.query("tbllop", null, null, null, null, null, null);
            while (c.moveToNext()) {
                String data = c.getString(0) + " - " + c.getString(1) + " - " + c.getString(2);
                mylist.add(data);
            }
            c.close();
            myadapter.notifyDataSetChanged();
        });
    }
}
