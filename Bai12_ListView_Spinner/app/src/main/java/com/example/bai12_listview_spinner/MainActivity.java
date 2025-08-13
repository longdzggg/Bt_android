package com.example.bai12_listview_spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

 class ListViewSpinnerDemo extends Activity {

    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.selection);

        // 1. Tạo dữ liệu
        final String arr1[] = {"Iphone 7", "SamSung Galaxy S7", "Nokia Lumia 730", "Sony Xperia XZ", "HTC One E9"};

        // 2. Khai báo Adapter
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr1);

        // 3. Gắn Adapter vào ListView
        ListView lv1 = findViewById(R.id.lv1);
        lv1.setAdapter(adapter1);

        // 4. Bắt sự kiện click
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int i, long arg3) {
                txt1.setText("Vị trí " + i + " : " + arr1[i]);
            }
        });
    }
}
