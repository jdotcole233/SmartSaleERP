package com.smartsaleerp.smartsale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.smartsaleerp.smartsale.Models.ValidationModel;


public class ValidateCredentials extends AppCompatActivity {

    private Spinner schoolSpinner;
    private EditText parentPhoneNumber, clientID;
    private Button validateButton;
    private CheckBox rememberDevice;
    ValidationModel validationModel;
    private String schoolSelected;
    private Boolean isRememberDeviceCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate_credentials);


        schoolSpinner = findViewById(R.id.list_of_schools);
        parentPhoneNumber = findViewById(R.id.parent_phone);
        clientID = findViewById(R.id.client_id);
        validateButton = findViewById(R.id.validate_button);
        rememberDevice = findViewById(R.id.rememberdevice);
        isRememberDeviceCheck = false;

        validationModel = new ValidationModel(this);

        ArrayAdapter<CharSequence> schoolsAdapter = ArrayAdapter.createFromResource(this, R.array.schools, android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(schoolsAdapter);

        schoolSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                schoolSelected = "sserp_associationintlschool";

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        rememberDevice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRememberDeviceCheck = isChecked;
            }
        });


        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenumber = parentPhoneNumber.getText().toString();
                String clientIdentifactionNumber = clientID.getText().toString();
                Intent validateCredentialsIntent = new Intent(ValidateCredentials.this, smartsale_dashborad.class);
               validationModel.validateUserAccount(schoolSelected, phonenumber, clientIdentifactionNumber, validateCredentialsIntent, isRememberDeviceCheck);
            }
        });



    }
}
