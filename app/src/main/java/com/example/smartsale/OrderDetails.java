package com.example.smartsale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;

import com.example.smartsale.Adapters.MessagesAdapter;
import com.example.smartsale.Adapters.OrderDetailsAdapter;
import com.example.smartsale.Models.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class OrderDetails extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<MenuModel> menuModels;
    private OrderDetailsAdapter messagesAdapter;
    private ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().setLayout((int)( displayMetrics.widthPixels * 0.9),(int)(displayMetrics.heightPixels * 0.7));

        menuModels = new ArrayList<>();
        recyclerView = findViewById(R.id.orderlist);
        backBtn = findViewById(R.id.orderdetailsback);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        menuModels.add(new MenuModel("Banku", "", "Very sweet", 2.34));
        menuModels.add(new MenuModel("Banku", "", "Very sweet", 2.34));
        menuModels.add(new MenuModel("Banku", "", "Very sweet", 2.34));
        menuModels.add(new MenuModel("Banku", "", "Very sweet", 2.34));
        menuModels.add(new MenuModel("Banku", "", "Very sweet", 2.34));
        menuModels.add(new MenuModel("Banku", "", "Very sweet", 2.34));
        menuModels.add(new MenuModel("Banku", "", "Very sweet", 2.34));
        menuModels.add(new MenuModel("Banku", "", "Very sweet", 2.34));

        messagesAdapter = new OrderDetailsAdapter( menuModels, this);
        recyclerView.setAdapter(messagesAdapter);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
