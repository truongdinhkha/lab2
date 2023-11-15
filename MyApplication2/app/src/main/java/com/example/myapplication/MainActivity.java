package com.example.myapplication;

import static com.example.myapplication.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private TextView textView;
    private String[] data;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        textView = findViewById(R.id.textView);
        // Dữ liệu mẫu
        data = new String[]{"Kha", "Khoi", "Huy", "Tuan", "Quyen"};

        // Tạo ArrayAdapter để kết nối dữ liệu với ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        // Thiết lập ArrayAdapter cho ListView
        listView.setAdapter(adapter);

        // Xử lý sự kiện khi một mục được chọn trong ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //đối số arg2 là vị trí phần tử trong DataSource (data)
                textView.setText("position :" + arg2 + "; value =" + data[arg2]);
            }
        });

    }
}