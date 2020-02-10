package com.tradinos.mzn.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tradinos.mzn.R;
import com.tradinos.mzn.models.Arrangement;
import com.tradinos.mzn.ui.itemdetailsactivity.ItemDetailsActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArrangementsAdapter extends RecyclerView.Adapter<ArrangementsAdapter.ArrangementViewHolder> {

    private ArrayList<Arrangement> arrangementsList;
    private Context mContext;

    public ArrangementsAdapter(ArrayList<Arrangement> arrangementsList, Context mContext) {
        this.arrangementsList = arrangementsList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ArrangementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArrangementViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.arrangement_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArrangementViewHolder holder, final int position) {

        holder.mTitle.setText(arrangementsList.get(position).getName());
        holder.mSubtitle.setText(arrangementsList.get(position).getDescription());

        String currencyName = mContext.getString(R.string.currency_name);

        holder.mPrice.setText(arrangementsList.get(position).getPrice()+" " + currencyName);

        if(arrangementsList.get(position).getActivated() == 1){
            holder.mNotActivatedIcon.setVisibility(View.GONE);
            holder.mItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, ItemDetailsActivity.class);
                    intent.putExtra("obj", arrangementsList.get(position));
                    mContext.startActivity(intent);
                }
            });
        }else{
            holder.mNotActivatedIcon.setVisibility(View.VISIBLE);
        }

        Glide.with(mContext)
                .load(arrangementsList.get(position).getImage_url())
                .centerCrop()
                .placeholder(R.drawable.ic_image_black_24dp)
                .into(holder.mItemImage);
    }

    @Override
    public int getItemCount() {
        return arrangementsList.size();
    }

    class ArrangementViewHolder extends RecyclerView.ViewHolder{

        View mItemView;
        ImageView mItemImage, mNotActivatedIcon;
        TextView mTitle, mPrice, mSubtitle;

        public ArrangementViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemView = itemView;
            mItemImage = itemView.findViewById(R.id.arrangement_item_image_view);
            mTitle = itemView.findViewById(R.id.arrangement_item_title_text_view);
            mSubtitle = itemView.findViewById(R.id.arrangement_item_subtitle_text_view);
            mPrice = itemView.findViewById(R.id.arrangement_item_price_text_view);
            mNotActivatedIcon = itemView.findViewById(R.id.not_activated_icon);

        }
    }
}
