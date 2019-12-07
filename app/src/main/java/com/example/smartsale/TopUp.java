package com.example.smartsale;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;


public class TopUp extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Spinner spinner;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        spinner = findViewById(R.id.paymentmethod);
        drawerLayout = findViewById(R.id.topupdrawer);
        navigationView = findViewById(R.id.topupNavigationView);
        imageButton = findViewById(R.id.topupnavigationbtn);


        ArrayAdapter<CharSequence> paymentMethodAdapter = ArrayAdapter.createFromResource(this, R.array.paymentmethod, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(paymentMethodAdapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
                navigationView.setNavigationItemSelectedListener(TopUp.this);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.smartsaledashboard:
                startActivity(new Intent(TopUp.this, smartsale_dashborad.class));
                finish();
                break;
            case R.id.smartsalemessages:
                startActivity(new Intent(TopUp.this, MainMessage.class));
                finish();
                break;
            case R.id.smartsaleorders:
                startActivity(new Intent(TopUp.this, OrderMeal.class));
                finish();
                break;
            case R.id.smartsaletopup:
                startActivity(new Intent(TopUp.this, TopUp.class));
                finish();
                break;
            case R.id.smartsalestting:

                break;
        }
        return false;
    }
}
