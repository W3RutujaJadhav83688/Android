package com.rutu12m.assign_5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeDetailsActivity extends AppCompatActivity {
    TextView textName,textDesg;
    ImageView image;
    Employee employee;
    //Employee employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_employee_details);

        textName = findViewById(R.id.textName);
        textDesg = findViewById(R.id.textDesg);
        image = findViewById(R.id.image);

        Intent intent = getIntent();
        employee = (Employee) intent.getSerializableExtra("employee");
        //Log.e("EmployeeDetailsActivity","EmployeeDetailsActivity"+employee);
        if(employee != null){
            image.setImageResource(employee.getImage());
            textName.setText("Name :"+employee.getName());
            textDesg.setText("Desg"+employee.getDesg());
        }


    }
}