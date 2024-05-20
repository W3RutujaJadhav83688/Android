package com.rutu12m.product_recycler;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolBar;
    RecyclerView recyclerView;
    List<Product> productList;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolBar = findViewById(R.id.toolBar);
        recyclerView = findViewById(R.id.recyclerView);
        setSupportActionBar(toolBar);

        productList = new ArrayList<>();
        productList.add(new Product("Apple",90.00,"healthy for body"));

        productList.add(new Product("Mango",91.00,"favourite food"));
        productList.add(new Product("Mango1",911.00,"favourite food1"));

        productAdapter = new ProductAdapter(this,productList);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add Product");
        return super.onCreateOptionsMenu(menu);
    }
    ActivityResultLauncher launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            Intent intent = result.getData();

            Product product = (Product) intent.getSerializableExtra("product");
            Log.e("MainActivity","MainActivity"+product);
            productList.add(product);
            productAdapter.notifyDataSetChanged();

        }
    });

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, AddProductActivity.class);
        launcher.launch(intent);
        return super.onOptionsItemSelected(item);
    }
}
