package com.example.task71p;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class CreateItemActivity extends AppCompatActivity {

    private EditText editTextName, editTextPhone, editTextDescription, editTextDate, editTextLocation;
    private RadioGroup radioGroupPostType;
    private Button buttonSave;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_advert);

        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextDate = findViewById(R.id.editTextDate);
        editTextLocation = findViewById(R.id.editTextLocation);
        radioGroupPostType = findViewById(R.id.radioGroupPostType);
        buttonSave = findViewById(R.id.buttonSave);
        databaseHelper = new DatabaseHelper(this);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postType = ((RadioButton) findViewById(radioGroupPostType.getCheckedRadioButtonId())).getText().toString();
                String name = editTextName.getText().toString();
                String phone = editTextPhone.getText().toString();
                String description = editTextDescription.getText().toString();
                String date = editTextDate.getText().toString();
                String location = editTextLocation.getText().toString();

                Item item = new Item(-1, postType, name, phone, description, date, location);
                databaseHelper.addItem(item);

                finish();  // Close this activity and return to MainActivity
            }
        });
    }
}


