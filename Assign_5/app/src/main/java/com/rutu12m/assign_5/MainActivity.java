package com.rutu12m.assign_5;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ViewPager2 viewPager;
    List<Employee> employeeList;
    EmployeeAdapter employeeAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        viewPager = findViewById(R.id.viewPager);
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(R.drawable.emp1,"Rutuja","Software Engineer"));
        employeeList.add(new Employee(R.drawable.emp2,"Vedika","database developer"));
       employeeAdapter  = new EmployeeAdapter(this,employeeList);
       recyclerView.setAdapter(employeeAdapter);
       recyclerView.setLayoutManager(new GridLayoutManager(this,1));
       employeeAdapter.notifyDataSetChanged();


    }
}