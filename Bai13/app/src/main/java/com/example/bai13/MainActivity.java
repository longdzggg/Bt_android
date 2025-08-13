package com.example.bai13;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String arr[] = {"Hà Nội", "Huế", "Sài Gòn", "Hà Giang", "Hội An", "Kiên Giang", "Lâm Đồng", "Long Khánh"};

    AutoCompleteTextView singleComplete;
    MultiAutoCompleteTextView multiComplete;
    TextView selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selection = findViewById(R.id.selection);

        singleComplete = findViewById(R.id.editauto);
        multiComplete = findViewById(R.id.multiAutoCompleteTextView1);

        // Adapter cho AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);

        // Gán adapter cho AutoCompleteTextView và MultiAutoCompleteTextView
        singleComplete.setAdapter(adapter);
        multiComplete.setAdapter(adapter);

        // Thiết lập dấu phân cách cho MultiAutoCompleteTextView
        multiComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        // Bắt sự kiện khi text thay đổi trong AutoCompleteTextView
        singleComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Không dùng
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Không dùng
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Hiển thị text vừa chọn lên TextView
                selection.setText(singleComplete.getText().toString());
            }
        });
    }
}
