package com.tradinos.mzn.ui.itemdetailsactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tradinos.mzn.R;
import com.tradinos.mzn.models.Tray;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArrangementTraysAdapter extends RecyclerView.Adapter<ArrangementTraysAdapter.TrayViewHolder> {


    private ArrayList<Tray> traysList;
    private Context mContext;
    private int currentSelectedTrayPosition;
    private TrayViewHolder currentSelectedTrayHolder;
    private SelectTrayCallBack selectTrayCallBack;

    public ArrangementTraysAdapter(ArrayList<Tray> traysList, Context mContext) {
        this.traysList = traysList;
        this.mContext = mContext;
        currentSelectedTrayPosition = -1;
        selectTrayCallBack = (SelectTrayCallBack) mContext;
    }

    @NonNull
    @Override
    public ArrangementTraysAdapter.TrayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArrangementTraysAdapter.TrayViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tray_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ArrangementTraysAdapter.TrayViewHolder holder, final int position) {

        holder.mTitle.setText(traysList.get(position).getName());
        String currencyName = mContext.getString(R.string.currency_name);

        holder.mPrice.setText(traysList.get(position).getPrice()+" " + currencyName);

        if(currentSelectedTrayPosition != -1){
            if(position == currentSelectedTrayPosition){
                holder.mItemView.setBackgroundResource(R.drawable.selected_item_background);
                currentSelectedTrayPosition = position;
                currentSelectedTrayHolder = holder;
            }else{
                holder.mItemView.setBackgroundResource(R.drawable.not_selected_item_background);
            }
        }

        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSelectedTrayPosition != -1){
                    if(currentSelectedTrayPosition != position){
                        holder.mItemView.setBackgroundResource(R.drawable.selected_item_background);
                        currentSelectedTrayPosition = position;
                        currentSelectedTrayHolder.mItemView.setBackgroundResource(R.drawable.not_selected_item_background);
                        currentSelectedTrayHolder = holder;
                        selectTrayCallBack.selectTrayCall(traysList.get(position));
                    }else {
                        holder.mItemView.setBackgroundResource(R.drawable.not_selected_item_background);
                        currentSelectedTrayHolder = null;
                        currentSelectedTrayPosition = -1;
                        selectTrayCallBack.selectTrayCall(null);
                    }
                }else{
                    holder.mItemView.setBackgroundResource(R.drawable.selected_item_background);
                    currentSelectedTrayPosition = position;
                    currentSelectedTrayHolder = holder;
                    selectTrayCallBack.selectTrayCall(traysList.get(position));
                }
            }
        });

        Glide.with(mContext)
                .load(traysList.get(position).getImage_url())
                .centerCrop()
                .placeholder(R.drawable.ic_image_black_24dp)
                .into(holder.mItemImage);
    }

    @Override
    public int getItemCount() {
        return traysList.size();
    }

    class TrayViewHolder extends RecyclerView.ViewHolder{

        View mItemView;
        ImageView mItemImage;
        TextView mTitle, mPrice;

        public TrayViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemView = itemView;
            mItemImage = itemView.findViewById(R.id.tray_image_view);
            mTitle = itemView.findViewById(R.id.tray_title_text_view);
            mPrice = itemView.findViewById(R.id.tray_price_text_view);

        }
    }


    public interface SelectTrayCallBack{
        public void selectTrayCall(Tray tray);
    }

}
