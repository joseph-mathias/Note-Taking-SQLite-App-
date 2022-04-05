package com.nchimunya.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCountryActivity extends Activity implements View.OnClickListener {

    //Widget
    private Button addTodoButton;
    private EditText subjectEditText;
    private EditText descriptionEditText;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Record");
        setContentView(R.layout.activity_add_country);

        //Instantiation of Widgets:
        subjectEditText = findViewById(R.id.subject_edittext);
        descriptionEditText = findViewById(R.id.description_edittext);
        addTodoButton = findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_record:
                final String name = subjectEditText.getText().toString();
                final String description = descriptionEditText.getText().toString();

                dbManager.insert(name, description);

                Intent main = new Intent(AddCountryActivity.this, CountryListActivity.class )
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }
}