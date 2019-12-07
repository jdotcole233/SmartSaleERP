package com.example.smartsale.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartsale.Models.MenuModel;
import com.example.smartsale.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuAdapterHolder> {

    private List<MenuModel> menus;
    private Context context;

    public MenuAdapter(List<MenuModel> menus, Context context) {
        this.menus = menus;
        this.context = context;
    }

    @Override
    public MenuAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MenuAdapterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MenuAdapterHolder holder, int position) {
            holder.foodDescription.setText(menus.get(position).getFoodDetails());
            holder.foodPrice.setText(menus.get(position).getPrice() + "");
            holder.foodName.setText(menus.get(position).getFoodname());
           // holder.foodImage.setImageResource();
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public static class MenuAdapterHolder extends RecyclerView.ViewHolder {

        private TextView foodDescription, foodPrice, foodName;
        private ImageView foodImage;
        private ImageButton addFooodBtn, removeFoodBtn;

        public MenuAdapterHolder(View itemView) {
            super(itemView);
            foodDescription = itemView.findViewById(R.id.fooddetails);
            foodImage = itemView.findViewById(R.id.foodimage);
            addFooodBtn = itemView.findViewById(R.id.addfoodtoselection);
            removeFoodBtn = itemView.findViewById(R.id.removefromselection);
            foodPrice = itemView.findViewById(R.id.foodprice);
            foodName = itemView.findViewById(R.id.foodname);
        }
    }
}
