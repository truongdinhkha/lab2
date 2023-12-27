package com.example.myapplication.Bai5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Bai5 extends AppCompatActivity {

    EditText edtName;
    CheckBox chbxManager;
    Button btnAdd;
    ListView lv_Employee;
    ArrayList<Bai5_Employee> employees;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);

        edtName = (EditText) findViewById(R.id.edtName);
        chbxManager = (CheckBox) findViewById(R.id.chbxManager);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        lv_Employee = (ListView) findViewById(R.id.lv_Employee);
        employees = new ArrayList<Bai5_Employee>();

        adapter = new EmployeeAdapter(this, R.layout.bai5_item,employees);
        lv_Employee.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                Bai5_Employee employee = new Bai5_Employee();
                if (chbxManager.isChecked())
                {
                    employee.setManager(true);
                }
                else
                {
                    employee.setManager(false);
                }
                employee.setFullName(name);
                //Đưa employee vào ArrayList
                employees.add(employee);
                //Cập nhập giao diện
                adapter.notifyDataSetChanged();
            }
        });
    }
}