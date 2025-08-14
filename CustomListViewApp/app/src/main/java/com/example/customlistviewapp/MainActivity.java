package com.example.customlistviewapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Phone> phoneList;
    MyArrayAdapter adapter;

    String[] names = {"Điện thoại iPhone 12", "Điện thoại Samsung S20", "Điện thoại Nokia 6",
            "Điện thoại Bphone 2020", "Điện thoại Oppo 5", "Điện thoại VSmart Joy2"};
    int[] images = {R.drawable.ip, R.drawable.samsung, R.drawable.htc,
            R.drawable.lg, R.drawable.wp, R.drawable.sky};
    String[] prices = {"25.000.000đ", "18.000.000đ", "3.500.000đ",
            "9.990.000đ", "7.500.000đ", "4.800.000đ"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        phoneList = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            phoneList.add(new Phone(names[i], images[i], prices[i]));
        }

        adapter = new MyArrayAdapter(this, R.layout.layout_listview, phoneList);
        lv.setAdapter(adapter);
    }
}
