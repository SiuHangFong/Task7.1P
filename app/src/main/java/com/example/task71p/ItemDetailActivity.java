package com.example.task71p;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    private TextView textViewItemDescription;
    private TextView textViewItemDate;
    private TextView textViewItemLocation;
    private Button buttonRemove;
    private Button buttonBack;
    private DatabaseHelper databaseHelper;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_item);

        textViewItemDescription = findViewById(R.id.textViewItemDescription);
        textViewItemDate = findViewById(R.id.textViewItemDate);
        textViewItemLocation = findViewById(R.id.textViewItemLocation);
        buttonRemove = findViewById(R.id.buttonRemove);
        buttonBack = findViewById(R.id.buttonBack);
        databaseHelper = new DatabaseHelper(this);

        int itemId = getIntent().getIntExtra("itemId", -1);
        item = databaseHelper.getItem(itemId);

        if (item != null) {
            String displayText = item.getPostType().equals("Lost") ? "Lost - " + item.getDescription() : "Found - " + item.getDescription();
            textViewItemDescription.setText(displayText);
            textViewItemDate.setText(item.getDate());
            textViewItemLocation.setText(item.getLocation());
        }

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item != null) {
                    databaseHelper.deleteItem(item);
                }
                finish();  // Close this activity and return to MainActivity
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Close this activity and return to ShowItemsActivity
            }
        });
    }
}


