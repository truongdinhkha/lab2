package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class Bai6 extends AppCompatActivity {

    EditText edtName;
    CheckBox chbxManager;
    Button btnAdd;
    RecyclerView rcv_Employee;
    ArrayList<Bai6_Employee> employees;
    Bai6_EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai6_employee);

        edtName = (EditText) findViewById(R.id.edtName);
        chbxManager = (CheckBox) findViewById(R.id.chbxManager);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        rcv_Employee = (RecyclerView) findViewById(R.id.rcv_Employee);
        employees = new ArrayList<Bai6_Employee>();

        adapter = new Bai6_EmployeeAdapter(this, R.layout.bai6_item_employee,employees);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_Employee.setLayoutManager(linearLayoutManager);
        rcv_Employee.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                Bai6_Employee employee = new Bai6_Employee();
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