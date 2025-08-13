package com.example.bai12_listview_spinner;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

 class ListViewSpinner extends Activity {

    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String> arrAdapter;
    EditText edtwork, edth, edtm;
    TextView txtdate;
    Button btnwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_spinner_demo);


        edth = findViewById(R.id.edthour);
        edtm = findViewById(R.id.edtmi);
        edtwork = findViewById(R.id.edtwork);
        btnwork = findViewById(R.id.btnadd);
        lv = findViewById(R.id.listView1);
        txtdate = findViewById(R.id.txtdate);

        arraywork = new ArrayList<>();
        arrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraywork);
        lv.setAdapter(arrAdapter);

        // Lấy ngày hiện tại
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText("Hôm Nay: " + sdf.format(currentDate));

        // Nút thêm công việc
        btnwork.setOnClickListener(v -> {
            if (edtwork.getText().toString().equals("") || edth.getText().toString().equals("") || edtm.getText().toString().equals("")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListViewSpinner.this);
                builder.setTitle("Info missing");
                builder.setMessage("Please enter all information of the work");
                builder.setPositiveButton("Continue", (dialog, which) -> {});
                builder.show();
            } else {
                String str = edtwork.getText().toString() + " - " + edth.getText().toString() + ":" + edtm.getText().toString();
                arraywork.add(str);
                arrAdapter.notifyDataSetChanged();
                edth.setText("");
                edtm.setText("");
                edtwork.setText("");
            }
        });

        // Xóa khi click vào item
        lv.setOnItemClickListener((parent, view, position, id) -> {
            arraywork.remove(position);
            arrAdapter.notifyDataSetChanged();
        });
    }
}
