package com.example.task71p;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonCreateAdvert;
    private Button buttonShowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCreateAdvert = findViewById(R.id.buttonCreateAdvert);
        buttonShowItems = findViewById(R.id.buttonShowItems);

        buttonCreateAdvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateItemActivity.class);
                startActivity(intent);
            }
        });

        buttonShowItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowItemsActivity.class);
                startActivity(intent);
            }
        });
    }
}

