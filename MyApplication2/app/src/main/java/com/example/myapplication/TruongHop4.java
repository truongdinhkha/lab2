package com.example.myapplication;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class TruongHop4 extends AppCompatActivity {

    EditText editId,editName;
    Button btnNhap;
    RadioGroup radgroup;
    ListView lvNhanvien;
    ArrayList<Employee>arrEmployee=new ArrayList<Employee>();
    ArrayAdapter<Employee>adapter=null;
    //Khai báo 1 employee object
    Employee employee=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truong_hop4);
        editId=(EditText) findViewById(R.id.editMa);
        editName=(EditText) findViewById(R.id.editTen);
        btnNhap=(Button) findViewById(R.id.btnnhap);
        radgroup=(RadioGroup) findViewById(R.id.radiogroud1);
        lvNhanvien=(ListView) findViewById(R.id.lvnhanvien);
        //đưa Data Source là các employee vào Adapter
        adapter=new ArrayAdapter<Employee>(this,
                android.R.layout.simple_list_item_1,
                arrEmployee);
        //đưa adapter vào ListView
        lvNhanvien.setAdapter(adapter);

        btnNhap.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                processNhap();
            }
        });
    }
    //Xử lý sự kiện nhập
    public void processNhap()
    {
        //Lấy ra đúng id của Radio Button được checked
        int radId=radgroup.getCheckedRadioButtonId();
        String id=editId.getText()+"";
        String name=editName.getText()+"";
        if(radId==R.id.radChinhthuc)
        {
            //tạo instance là FullTime
            employee=new EmployeeFT();
        }
        else
        {
            //Tạo instance là Partime
            employee=new EmployeePT();
        }
        //FullTime hay Partime thì cũng là Employee
        //nên có các hàm này là hiển nhiên
        employee.setId(id);
        employee.setName(name);
        //Đưa employee vào ArrayList
        arrEmployee.add(employee);
        //Cập nhập giao diện
        adapter.notifyDataSetChanged();
    }

    public abstract static class Employee {
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public abstract double TinhLuong();
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return this.id+" - "+this.name;
        }
    }

    public static class EmployeePT extends Employee {

        @Override
        public double TinhLuong() {
            // TODO Auto-generated method stub
            return 150;
        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return super.toString() +" -->PartTime="+TinhLuong();
        }
    }

    public static class EmployeeFT extends Employee {

        @Override
        public double TinhLuong() {
            return 500;
        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return super.toString() +" -->FullTime="+TinhLuong();
        }
    }
}