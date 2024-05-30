package com.rutu12m.assign_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class addEmployee extends AppCompatActivity {
    EditText editId,editName,editAge;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_employee);
        editId  = findViewById(R.id.editId);
        editName  =findViewById(R.id.editName);
        editAge  =findViewById(R.id.editAge);

    }
    public  void save(View view){
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(editId.getText().toString()));
        employee.setName(editName.getText().toString());
        employee.setAge(Integer.parseInt(editAge.getText().toString()));

        Intent intent = new Intent();
        intent.putExtra("employee",employee);
        setResult(0,intent);
        finish();

    }
}