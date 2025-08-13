package com.example.gridviewexample; // thay đổi theo package bạn

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {

    // Mảng dữ liệu hiển thị trên GridView
    String arr[] = {
            "Ipad", "Iphone", "New Ipad",
            "SamSung", "Nokia", "Sony Ericson",
            "LG", "Q-Mobile", "HTC", "Blackberry",
            "G Phone", "FPT - Phone", "HK Phone"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy các view từ layout
        final TextView selection = (TextView) findViewById(R.id.selection);
        final GridView gv = (GridView) findViewById(R.id.gridView1);

        // Tạo adapter để đổ dữ liệu mảng vào GridView
        ArrayAdapter<String> da = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );

        // Gán adapter cho GridView
        gv.setAdapter(da);

        // Thiết lập sự kiện click từng item trong GridView
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Hiển thị item được chọn trong TextView
                selection.setText(arr[position]);
            }
        });
    }
}
