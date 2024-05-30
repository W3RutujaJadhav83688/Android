package com.rutu12m.assign_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    List<Employee> employeeList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        listView = findViewById(R.id.listView);
        setSupportActionBar(toolbar);
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Rutuja", 23));
        employeeList.add(new Employee(2, "Vedika", 24));
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employeeList);
        listView.setAdapter(arrayAdapter);
    }

        ActivityResultLauncher activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent = result.getData();
                Employee employee = (Employee) intent.getSerializableExtra("employee");
                if(employee != null){
                    employeeList.add(employee);
                    arrayAdapter.notifyDataSetChanged();
                }

            }
        });



        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.add_menu, menu);
            return super.onCreateOptionsMenu(menu);
        }
        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            Intent intent = new Intent(this, addEmployee.class);
            activityResultLauncher.launch(intent);
            return super.onOptionsItemSelected(item);
        }
    }
