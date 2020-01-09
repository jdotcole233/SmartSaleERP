package com.smartsaleerp.smartsale;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


import com.smartsaleerp.smartsale.Adapters.MenuAdapter;
import com.smartsaleerp.smartsale.Models.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class OrderMeal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<MenuModel> menus;
    private MenuAdapter menuAdapter;
    private ImageButton imageButton;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_meal);
        imageButton = findViewById(R.id.ordermealnavigationbtn);
        drawerLayout = findViewById(R.id.ordermealdrawer);
        navigationView = findViewById(R.id.navigationView);
        linearLayout = findViewById(R.id.ordercheckout);

        menus = new ArrayList<>();
        recyclerView = findViewById(R.id.foodgridlist);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        menus.add(new MenuModel("Rice", "", "Nice Banku", 2.3));
        menus.add(new MenuModel("Yam", "", "Nice Banku", 25.0));
        menus.add(new MenuModel("Banku", "", "Nice Banku", 12.3));
        menus.add(new MenuModel("Fufu", "", "Nice Banku", 11.00));
        menus.add(new MenuModel("Burger", "", "Nice Banku", 4.5));
        menus.add(new MenuModel("FriedChips", "", "Nice Banku", 2.3));
        menus.add(new MenuModel("Pizza", "", "Nice Banku", 2.3));
        menus.add(new MenuModel("Banku", "", "Nice Banku", 2.3));

        menuAdapter = new MenuAdapter(menus, this);
        recyclerView.setAdapter(menuAdapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
                navigationView.setNavigationItemSelectedListener(OrderMeal.this);
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderMeal.this, OrderDetails.class));
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId()){
            case R.id.smartsaledashboard:
                startActivity(new Intent(OrderMeal.this, smartsale_dashborad.class));
                finish();
                break;
            case R.id.smartsalemessages:
                startActivity(new Intent(OrderMeal.this, MainMessage.class));
                finish();
                break;
            case R.id.smartsaleorders:
                startActivity(new Intent(OrderMeal.this, OrderMeal.class));
                finish();
                break;
            case R.id.smartsaletopup:
                startActivity(new Intent(OrderMeal.this, TopUp.class));
                finish();
                break;
            case R.id.smartsalestting:

                break;
        }
        return false;
    }

    public void navigateScreens(){

    }
}
