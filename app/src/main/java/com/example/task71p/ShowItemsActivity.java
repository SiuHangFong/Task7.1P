package com.example.task71p;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ShowItemsActivity extends AppCompatActivity {

    private ListView listViewItems;
    private DatabaseHelper databaseHelper;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_items);

        listViewItems = findViewById(R.id.listViewItems);
        buttonBack = findViewById(R.id.buttonBack);
        databaseHelper = new DatabaseHelper(this);

        loadItems();

        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = (Item) listViewItems.getItemAtPosition(position);

                Intent intent = new Intent(ShowItemsActivity.this, ItemDetailActivity.class);
                intent.putExtra("itemId", item.getId());
                startActivity(intent);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowItemsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadItems();  // Reload items when returning from other activities
    }

    private void loadItems() {
        List<Item> items = databaseHelper.getAllItems();
        ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, items) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                // Modify the item text to the desired format
                Item item = items.get(position);
                String displayText = item.getPostType().equals("Lost") ? "Lost - " + item.getDescription() : "Found - " + item.getDescription();
                textView.setText(displayText);

                return view;
            }
        };
        listViewItems.setAdapter(adapter);
    }
}

