package com.example.smartsale;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.smartsale.Adapters.MessagesAdapter;
import com.example.smartsale.Models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class MainMessage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private  List<MessageModel> messages;
    private MessagesAdapter messagesAdapter;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_message);
        recyclerView = findViewById(R.id.mainmessagelist);
        imageButton = findViewById(R.id.messagenavigationbtn);
        drawerLayout = findViewById(R.id.messagedrawer);
        navigationView = findViewById(R.id.messageNavigationView);

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
                navigationView.setNavigationItemSelectedListener(MainMessage.this);
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.smartsaledashboard:
                startActivity(new Intent(MainMessage.this, smartsale_dashborad.class));
                finish();
                break;
            case R.id.smartsalemessages:
                startActivity(new Intent(MainMessage.this, MainMessage.class));
                finish();
                break;
            case R.id.smartsaleorders:
                startActivity(new Intent(MainMessage.this, OrderMeal.class));
                finish();
                break;
            case R.id.smartsaletopup:
                startActivity(new Intent(MainMessage.this, TopUp.class));
                finish();
                break;
            case R.id.smartsalestting:

                break;
        }
        return false;
    }
}
