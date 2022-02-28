package com.smartsaleerp.smartsale.Models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smartsaleerp.smartsale.Miscellaneous.SmartSaleUtility;
import com.smartsaleerp.smartsale.ValidateCredentials;

import java.util.HashMap;
import java.util.Iterator;

public class ValidationModel {
    private final String COLLECTION_NAME = "cafeteria_collection";
    boolean client_exists = false;
    private HashMap<String, String> client_details;
    Context context;
    SmartSaleUtility smartSaleUtility;


    public ValidationModel(Context context) {
        this.context = context;
        smartSaleUtility = new SmartSaleUtility(context);
        this.client_details = new HashMap<>();
    }

    public DatabaseReference databaseConnection(String schoolname){
        return FirebaseDatabase.getInstance().getReference(COLLECTION_NAME).child(schoolname);
    }


    public boolean validateUserAccount(String school_name, String phone_number, String client_id, final Intent intent, final Boolean remeberdevice){
        databaseConnection(school_name).child("clients").child(phone_number).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    client_exists = true;
                    client_details = populateMap(dataSnapshot);
                    intent.putExtra("infor", client_details);

                        if (remeberdevice){
                            Boolean bool = smartSaleUtility.saveUserData("SAVED_DATA", client_details);
                            Log.i("SmartSalae", bool + " saving ");
                        } else {
                            Log.i("SmartSalae",  remeberdevice + " saving ");
                        }

                    context.startActivity(intent);
                    ((ValidateCredentials)context).finish();
                    Log.i("SmartSale", client_details.get("parent name"));

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return client_exists;
    }


    public HashMap<String, String> populateMap(DataSnapshot snapshot){
        HashMap<String, String> data = new HashMap<>();

        for (DataSnapshot dataSnapshot: snapshot.getChildren()){
            if (dataSnapshot.getKey().equals("balance_inquiry")){
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    data.put(dataSnapshot1.getKey(), dataSnapshot1.getValue().toString());
                }

            } else {
                data.put(dataSnapshot.getKey(), dataSnapshot.getValue().toString());
            }

        }
        return data;
    }


}
