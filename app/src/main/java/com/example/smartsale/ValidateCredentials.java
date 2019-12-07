package com.example.smartsale;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class ValidateCredentials extends AppCompatActivity {

    private Spinner schoolSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate_credentials);

        schoolSpinner = findViewById(R.id.list_of_schools);
        ArrayAdapter<CharSequence> schoolsAdapter = ArrayAdapter.createFromResource(this, R.array.schools, android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(schoolsAdapter);
    }
}
