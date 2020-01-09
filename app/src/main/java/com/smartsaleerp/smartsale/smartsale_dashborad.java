package com.smartsaleerp.smartsale;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


import com.smartsaleerp.smartsale.Adapters.MessagesAdapter;
import com.smartsaleerp.smartsale.Models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class smartsale_dashborad extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private  RecyclerView.LayoutManager layoutManager;
    private List<MessageModel> messages;
    private MessagesAdapter messagesAdapter;
    private ImageButton imageButton;
    private DrawerLayout drawerLayout;
    private  NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartsale_dashborad);

        recyclerView = findViewById(R.id.messagelist);
        imageButton = findViewById(R.id.dashboardnavigationbtn);
        drawerLayout = findViewById(R.id.dashboarddrawer);
        navigationView = findViewById(R.id.dashboardNavigationView);


        messages = new ArrayList<>();
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        messages.add(new MessageModel("Hello Sir, Your child needs food", "11:30 am", "Harold Okai"));
        messages.add(new MessageModel("Hello Sir, Your child needs food", "06:30 pm", "Sampson Addai"));
        messages.add(new MessageModel("Hello Sir, Your child needs food", "12:15 pm", "Foster Fister"));
        messages.add(new MessageModel("Hello Sir, Your child needs food", "11:30 am", "Derrick Epson"));
        messages.add(new MessageModel("Hello Sir, Your child needs food", "11:30 am", "Harold Okai"));
        messages.add(new MessageModel("Hello Sir, Your child needs food", "11:30 am", "Harold Okai"));

        messagesAdapter = new MessagesAdapter(messages, this);
        recyclerView.setAdapter(messagesAdapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
                navigationView.setNavigationItemSelectedListener(smartsale_dashborad.this);

            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.smartsaledashboard:
                startActivity(new Intent(smartsale_dashborad.this, smartsale_dashborad.class));
                finish();
                break;
            case R.id.smartsalemessages:
                startActivity(new Intent(smartsale_dashborad.this, MainMessage.class));
                finish();
                break;
            case R.id.smartsaleorders:
                startActivity(new Intent(smartsale_dashborad.this, OrderMeal.class));
                finish();
                break;
            case R.id.smartsaletopup:
                startActivity(new Intent(smartsale_dashborad.this, TopUp.class));
                finish();
                break;
            case R.id.smartsalestting:

                break;
        }
        return false;
    }
}
