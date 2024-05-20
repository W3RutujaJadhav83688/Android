package com.rutu12m.product_recycler;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddProductActivity extends AppCompatActivity {
    EditText editName,editPrice,editDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_product);
        editName = findViewById(R.id.editName);
        editPrice = findViewById(R.id.editPrice);
        editDescription = findViewById(R.id.editDescription);

    }
    public void save(View view){
        Product product = new Product();
        product.setName(editName.getText().toString());
        product.setPrice(Double.parseDouble(editPrice.getText().toString()));
        product.setDescription(editDescription.getText().toString());

        Intent intent = new Intent();
        intent.putExtra("product",product);
        Log.e("AddProductActivity","AddProductActivity"+product);
        setResult(0,intent);
        finish();
    }
}