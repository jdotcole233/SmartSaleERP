package com.example.smartsale.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartsale.Models.MenuModel;
import com.example.smartsale.R;

import java.util.List;

public class OrderDetailsAdapter  extends RecyclerView.Adapter<OrderDetailsAdapter.OrderDetailsAdapterHolder> {

    private List<MenuModel> menuModels;
    private Context context;

    public OrderDetailsAdapter(List<MenuModel> menuModels, Context context) {
        this.menuModels = menuModels;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderDetailsAdapterHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new OrderDetailsAdapterHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_items, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailsAdapterHolder orderDetailsAdapterHolder, int i) {


    }

    @Override
    public int getItemCount() {
        return menuModels.size();
    }

    public static class OrderDetailsAdapterHolder extends RecyclerView.ViewHolder {

        public OrderDetailsAdapterHolder(View itemView) {
            super(itemView);
        }
    }
}
