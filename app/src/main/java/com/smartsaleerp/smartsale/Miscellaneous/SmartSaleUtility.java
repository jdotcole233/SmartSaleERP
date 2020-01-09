package com.smartsaleerp.smartsale.Miscellaneous;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SmartSaleUtility {

    SharedPreferences.Editor clientData;
    Context context;

    public SmartSaleUtility(Context context) {
        this.context = context;
    }

    public boolean saveUserData(String shared_name, HashMap<String, String> user_data){
        clientData = context.getSharedPreferences(shared_name, Context.MODE_PRIVATE).edit();
        for (Map.Entry<String, String> user : user_data.entrySet()){
            clientData.putString(user.getKey(), user.getValue());
        }
        return clientData.commit();
    }

    public Map<String, ?> readUserData(String shared_name){
        SharedPreferences clientData = context.getSharedPreferences(shared_name, Context.MODE_PRIVATE);
        return clientData.getAll();
    }
}
