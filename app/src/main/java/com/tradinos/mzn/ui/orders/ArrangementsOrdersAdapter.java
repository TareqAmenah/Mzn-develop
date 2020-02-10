package com.tradinos.mzn.ui.orders;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tradinos.mzn.R;
import com.tradinos.mzn.models.ArrangementOrder;
import com.tradinos.mzn.ui.orderdetails.OrderDetailsActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArrangementsOrdersAdapter extends RecyclerView.Adapter<ArrangementsOrdersAdapter.ArrangementOrderViewHolder> {


    private ArrayList<ArrangementOrder> arrangementOrders;
    private Context mContext;

    public ArrangementsOrdersAdapter(ArrayList<ArrangementOrder> arrangementOrders, Context mContext) {
        this.arrangementOrders = arrangementOrders;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ArrangementOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArrangementOrderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_order_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArrangementOrderViewHolder holder, final int position) {

        final ArrangementOrder order = arrangementOrders.get(position);
        final String currencyName = mContext.getString(R.string.currency_name);

        String orderNumber = mContext.getString(R.string.order_number) + order.getId();
        holder.mOrderNumberTextView.setText(orderNumber);
        holder.mTotalPriceTextView.setText(order.getTotal()+currencyName);
        String date = order.getCreated_date().substring(0, order.getCreated_date().indexOf(" ")+1);
        holder.mDateTextView.setText(date);

        switch (order.getStatus()) {
            case 1:
                holder.mStatusTextView.setText(mContext.getString(R.string.approved));
                break;

            case 2:
                holder.mStatusTextView.setText(mContext.getString(R.string.cancelled));
                break;
        }

        holder.mHolderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, OrderDetailsActivity.class);
                intent.putExtra("orderNumber", position+1);
                intent.putExtra("orderId", order.getId());
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrangementOrders.size();
    }

    class ArrangementOrderViewHolder extends RecyclerView.ViewHolder{

        TextView mTotalPriceTextView, mStatusTextView, mDateTextView, mOrderNumberTextView;
        View mHolderLayout;

        public ArrangementOrderViewHolder(@NonNull View itemView) {
            super(itemView);

            mTotalPriceTextView = itemView.findViewById(R.id.order_item_total_price);
            mStatusTextView = itemView.findViewById(R.id.order_item_status);
            mDateTextView = itemView.findViewById(R.id.order_item_date);
            mOrderNumberTextView = itemView.findViewById(R.id.order_item_order_number);

            mHolderLayout = itemView;

        }
    }

}
