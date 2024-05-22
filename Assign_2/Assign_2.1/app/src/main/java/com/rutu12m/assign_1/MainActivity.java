package com.rutu12m.assign_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editFirstName,editLastName,editEmail,editMobile;
    RadioButton radioMale,radioFemale;
    CheckBox checkboxVeg,checkboxNonVeg;
    private static final String tag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        editMobile = findViewById(R.id.editMobile);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        checkboxVeg = findViewById(R.id.checkboxVeg);
        checkboxNonVeg = findViewById(R.id.checkboxNonVeg);



    }
    public void save(View v){
        Intent intent = new Intent(this,DetailsActivity.class);
        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        String email = editEmail.getText().toString();
        String mobile = editMobile.getText().toString();
        List<String> food =new ArrayList<>();
        if(checkboxVeg.isChecked()) {
            food.add("panir");
        }
        else if (checkboxNonVeg.isChecked()) {
            food.add("chicken");
        }
            else{
            Toast.makeText(this,"choices can not be empty",Toast.LENGTH_LONG).show();


        }
            String gender;
            if(radioMale.isChecked()) {
                gender = "Male";
            }
            else if (radioFemale.isChecked()) {
                gender="Female";
            }
            else {
                gender = "";
            }
        Log.e(tag,"FirstName -"+firstName);
        Log.e(tag,"LastName -"+lastName);
        Log.e(tag,"Email -"+email);
        Log.e(tag,"Mobile -"+mobile);
        Log.e(tag,"food -"+food);
        Log.e(tag,"Gender -"+gender);
        intent.putExtra("FirstName",firstName);
        intent.putExtra("LastName",lastName);
        intent.putExtra("Email",email);
        intent.putExtra("Mobile",mobile);
        //food f1= new food();
        intent.putExtra("Food",food.toString());
        intent.putExtra("Gender",gender);
        startActivity(intent);
        finish();




    }
}