package com.tradinos.mzn.ui.itemdetailsactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tradinos.mzn.R;
import com.tradinos.mzn.models.Arrangement;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArrangementSizesAdapter extends RecyclerView.Adapter<ArrangementSizesAdapter.SizeViewHolder>{

    private ArrayList<Arrangement.ArrangementSize> arrangementSizesList;
    private Context mContext;
    private int currentSelectedSizesPosition;
    private SizeViewHolder currentSelectedItem;
    private SelectItemSizeCallBack selectItemSizeCallBack;

    public ArrangementSizesAdapter(ArrayList<Arrangement.ArrangementSize> arrangementSizesList, Context mContext) {
        this.arrangementSizesList = arrangementSizesList;
        this.mContext = mContext;
        currentSelectedSizesPosition = 0;
        selectItemSizeCallBack = (ArrangementSizesAdapter.SelectItemSizeCallBack) mContext;

    }

    @NonNull
    @Override
    public ArrangementSizesAdapter.SizeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArrangementSizesAdapter.SizeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.arrangement_size_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ArrangementSizesAdapter.SizeViewHolder holder, final int position) {

        String currencyName = mContext.getString(R.string.currency_name);

        holder.mTitle.setText(arrangementSizesList.get(position).getName());
        holder.mPrice.setText(arrangementSizesList.get(position).getPrice()+" " + currencyName);

        if(position == currentSelectedSizesPosition){
            holder.mItemView.setBackgroundResource(R.drawable.selected_item_background);
            currentSelectedSizesPosition = position;
            currentSelectedItem = holder;
        }else{
            holder.mItemView.setBackgroundResource(R.drawable.not_selected_item_background);
        }

        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentSelectedSizesPosition != position){
                    holder.mItemView.setBackgroundResource(R.drawable.selected_item_background);
                    currentSelectedSizesPosition = position;
                    currentSelectedItem.mItemView.setBackgroundResource(R.drawable.not_selected_item_background);
                    currentSelectedItem = holder;
                    selectItemSizeCallBack.selectItemSizeCall(arrangementSizesList.get(position));
                }
            }
        });

        Glide.with(mContext)
                .load(arrangementSizesList.get(position).getTrans_img())
                .centerCrop()
                .placeholder(R.drawable.ic_image_black_24dp)
                .into(holder.mItemImage);
    }

    @Override
    public int getItemCount() {
        return arrangementSizesList.size();
    }

    class SizeViewHolder extends RecyclerView.ViewHolder{

        View mItemView;
        ImageView mItemImage;
        TextView mTitle, mPrice;

        public SizeViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemView = itemView;
            mItemImage = itemView.findViewById(R.id.arrangement_size_item_image_view);
            mTitle = itemView.findViewById(R.id.arrangement_size_item_title_text_view);
            mPrice = itemView.findViewById(R.id.arrangement_size_item_price_text_view);

        }
    }


    public interface SelectItemSizeCallBack{
        public void selectItemSizeCall(Arrangement.ArrangementSize arrangementSize);
    }
}
