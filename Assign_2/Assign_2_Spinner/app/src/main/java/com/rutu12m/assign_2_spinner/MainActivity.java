package com.rutu12m.assign_2_spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerCountry, spinnerState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerState = findViewById(R.id.spinnerState);

        String[] countries = {"Select a country","Canada","India"};
        String[][] states ={
                {"Select a state"},

                {"Ontario", "Quebec", "British Columbia", "Alberta"},
        {"Maharashtra", "Karnataka", "Tamil Nadu", "Uttar Pradesh"}
    };

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,countries);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(countryAdapter);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> stateAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_item,states[position]);
                stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerState.setAdapter(stateAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}