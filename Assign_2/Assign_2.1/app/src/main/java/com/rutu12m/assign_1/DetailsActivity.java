package com.rutu12m.assign_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity {
    TextView textFirstName,textLastName,textEmail,textMobile,textGender,
            textFoodChoices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);
        textFirstName = findViewById(R.id.textFirstName);
        textLastName = findViewById(R.id.textLastName);
        textEmail = findViewById(R.id.textEmail);
        textMobile = findViewById(R.id.textMobile);
        textGender = findViewById(R.id.textGender);
        textFoodChoices = findViewById(R.id.textFoodChoices);
        Intent intent = getIntent();
        String FirstName = intent.getStringExtra("FirstName");
        String LastName = intent.getStringExtra("LastName");
        String Email = intent.getStringExtra("Email");
        String Mobile = intent.getStringExtra("Mobile");
        String Gender = intent.getStringExtra("Gender");
        //food f1= (food)intent.getSerializableExtra("55");
        String food = intent.getStringExtra("Food");


        textFirstName.setText(FirstName);

        textLastName.setText(LastName);

        textEmail.setText(Email);

        textMobile.setText(Mobile);
        textGender.setText(Gender);
        textFoodChoices.setText(food);







    }
}