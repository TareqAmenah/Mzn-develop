package com.tradinos.mzn.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tradinos.mzn.R;
import com.tradinos.mzn.models.Category;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    private ArrayList<Category> categoriesList;
    private Context mContext;

    public CategoriesAdapter(ArrayList<Category> categoriesList, Context mContext) {
        this.categoriesList = categoriesList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder holder, final int position) {

        holder.mCategoryTitle.setText(categoriesList.get(position).getName());
        holder.mCategorySubtitle.setText(categoriesList.get(position).getSubtitle());

        ArrangementsAdapter arrangementsAdapter = new ArrangementsAdapter(categoriesList.get(position).getArrangementsList(), mContext);
        GridLayoutManager layoutManager = new GridLayoutManager(mContext,1);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        holder.mElementsRecyclerView.setLayoutManager(layoutManager);

        holder.mElementsRecyclerView.setAdapter(arrangementsAdapter);
        final boolean expanded = categoriesList.get(position).isExpanded();

        if(expanded){
            holder.mElementsRecyclerView.setVisibility(View.VISIBLE);
        }else {
            holder.mElementsRecyclerView.setVisibility(View.GONE);
        }

        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoriesList.get(position).setExpanded(!expanded);
                holder.mElementsRecyclerView.setVisibility(expanded ? View.VISIBLE : View.GONE);
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }


    class CategoryViewHolder extends RecyclerView.ViewHolder {

        View mItemView;
        TextView mCategoryTitle, mCategorySubtitle;
        RecyclerView mElementsRecyclerView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemView = itemView;
            mCategoryTitle = itemView.findViewById(R.id.category_title);
            mCategorySubtitle = itemView.findViewById(R.id.category_subtitle);
            mElementsRecyclerView = itemView.findViewById(R.id.arrangement_items_recycler_view);
        }
    }
}
