package com.tradinos.mzn.ui.orderdetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tradinos.mzn.R;
import com.tradinos.mzn.models.OrderDetails;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderDetailsItemsAdapter extends RecyclerView.Adapter<OrderDetailsItemsAdapter.ItemViewHolder>{

    private OrderDetails orderDetails;
    private ArrayList<OrderDetailsItemElement> orderDetailsItemElements;

    public OrderDetailsItemsAdapter(OrderDetails orderDetails, Context context) {
        this.orderDetails = orderDetails;
        final String currencyName = context.getString(R.string.currency_name);


        orderDetailsItemElements = new ArrayList<>();

        for (OrderDetails.ArrangementInOrderDetails arrangment : orderDetails.getArrangments()) {
            orderDetailsItemElements.add(new OrderDetailsItemElement(
                    arrangment.getName(),
                    arrangment.getPivot().getQuantity() + "",
                    arrangment.getPivot().getArrangment_price() + currencyName
            ));
        }

        for (OrderDetails.TrayInOrderDetails tray : orderDetails.getTrays()) {
            orderDetailsItemElements.add(new OrderDetailsItemElement(
                    tray.getName(),
                    tray.getPivot().getQuantity() + "",
                    tray.getPrice() + currencyName
            ));
        }

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.order_details_item_element,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        OrderDetailsItemElement orderDetailsItemElement = orderDetailsItemElements.get(position);
        holder.mItemName.setText(orderDetailsItemElement.getName());
        holder.mItemPrice.setText(orderDetailsItemElement.getPrice());
        holder.mItemQuantity.setText(orderDetailsItemElement.getQuantity());

    }

    @Override
    public int getItemCount() {
        return orderDetailsItemElements.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView mItemName, mItemQuantity, mItemPrice;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemName = itemView.findViewById(R.id.order_details_item_element_item_name);
            mItemQuantity = itemView.findViewById(R.id.order_details_item_element_item_quantity);
            mItemPrice = itemView.findViewById(R.id.order_details_item_element_item_price);

        }
    }


    private class OrderDetailsItemElement{
        String name, quantity, price;

        public OrderDetailsItemElement(String name, String quantity, String price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }


}
