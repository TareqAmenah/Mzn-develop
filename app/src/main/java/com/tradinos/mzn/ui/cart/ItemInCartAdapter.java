package com.tradinos.mzn.ui.cart;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tradinos.mzn.R;
import com.tradinos.mzn.models.ItemInCart;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemInCartAdapter extends RecyclerView.Adapter<ItemInCartAdapter.ItemViewHolder>{

    private ArrayList<ItemInCart> itemsList;
    private Context mContext;
    private CalculateTotalCallBack calculateTotalCallBack;
    private String currencyName;


    ItemInCartAdapter(ArrayList<ItemInCart> itemsList, Context mContext) {
        this.itemsList = itemsList;
        this.mContext = mContext;
        calculateTotalCallBack = (CalculateTotalCallBack) mContext;
        currencyName = mContext.getString(R.string.currency_name);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int position) {



        final ItemInCart itemInCart = itemsList.get(position);
        holder.itemName.setText(itemInCart.getName());
        holder.itemPrice.setText(itemInCart.getPrice()+currencyName);
        holder.itemCount.setText(itemInCart.getQuantity()+"");

        Glide.with(mContext)
                .load(itemInCart.getImage_url())
                .centerCrop()
                .placeholder(R.drawable.ic_image_black_24dp)
                .into(holder.itemImage);

        holder.itemPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentCount = itemInCart.getQuantity();
                currentCount++;
                itemInCart.setQuantity(currentCount);
                holder.itemCount.setText(currentCount+"");
                calculateTotalCallBack.calculateTotalCall();
            }
        });

        holder.itemMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentCount = itemInCart.getQuantity();
                if(currentCount>1){
                    currentCount--;
                    itemInCart.setQuantity(currentCount);
                    holder.itemCount.setText(currentCount+"");
                    calculateTotalCallBack.calculateTotalCall();
                }
            }
        });

        holder.itemCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() != 0){
                    int newValue = Integer.valueOf(charSequence.toString());

                    if(newValue <= 0){
                        holder.itemCount.setText(itemInCart.getQuantity()+"");
                        return;
                    }
                    itemInCart.setQuantity(newValue);
                    calculateTotalCallBack.calculateTotalCall();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        holder.deleteImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemsList.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
                calculateTotalCallBack.calculateTotalCall();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView itemName, itemPrice;
        Button itemPlusButton, itemMinusButton;
        ImageView itemImage, deleteImageButton;
        EditText itemCount;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.incart_item_name);
            itemPrice = itemView.findViewById(R.id.incart_item_price);
            itemPlusButton = itemView.findViewById(R.id.incart_item_plus);
            itemMinusButton = itemView.findViewById(R.id.incart_item_minus);
            itemImage = itemView.findViewById(R.id.incart_item_image);
            deleteImageButton = itemView.findViewById(R.id.incart_item_delete);
            itemCount = itemView.findViewById(R.id.incart_item_count);
        }
    }


    public interface CalculateTotalCallBack{
        public void calculateTotalCall();
    }

}
