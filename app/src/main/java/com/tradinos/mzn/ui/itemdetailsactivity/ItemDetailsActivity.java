package com.tradinos.mzn.ui.itemdetailsactivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tradinos.mzn.R;
import com.tradinos.mzn.data.MznCart;
import com.tradinos.mzn.models.Arrangement;
import com.tradinos.mzn.models.ItemInCart;
import com.tradinos.mzn.models.Tray;
import com.tradinos.mzn.ui.cart.MyCartActivity;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDetailsActivity extends AppCompatActivity
        implements ArrangementSizesAdapter.SelectItemSizeCallBack,
                    ArrangementTraysAdapter.SelectTrayCallBack{

    RecyclerView arrangemenetSizesRecyclerView;
    RecyclerView traysRecyclerView;
    ItemDetailsViewModel itemDetailsViewModel;
    Arrangement arrangement;
    int trayCount = 1, arrangementCount=1;
    private String currencyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        itemDetailsViewModel = ViewModelProviders.of(this).get(ItemDetailsViewModel.class);
        currencyName = getString(R.string.currency_name);
        setupUi();

        Button addToCartButton = findViewById(R.id.add_to_cart_button);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialogButtonClicked();
            }
        });

    }


    private void setupUi() {

        setupToolbar();

        arrangement = (Arrangement) getIntent().getSerializableExtra("obj");
        itemDetailsViewModel.setArrangement(arrangement);

        ImageView itemImageView = findViewById(R.id.item_image_view);
        TextView itemTitle = findViewById(R.id.item_title_text_view);
        TextView itemSubTitle = findViewById(R.id.item_subtitle_text_view);
        final TextView itemPrice = findViewById(R.id.item_price_text_view);


        itemTitle.setText(arrangement.getName());
        itemSubTitle.setText(arrangement.getDescription());

        Glide.with(this)
                .load(arrangement.getImage_url())
                .placeholder(R.drawable.ic_image_black_24dp)
                .centerCrop()
                .into(itemImageView);



        arrangemenetSizesRecyclerView = findViewById(R.id.arrangement_sizes_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        arrangemenetSizesRecyclerView.setLayoutManager(layoutManager);
        ArrangementSizesAdapter arrangementSizesAdapter = new ArrangementSizesAdapter(arrangement.getSizes(), this);
        arrangemenetSizesRecyclerView.setAdapter(arrangementSizesAdapter);

        itemDetailsViewModel.getSelectedItemSize().observe(this, new Observer<Arrangement.ArrangementSize>() {
            @Override
            public void onChanged(Arrangement.ArrangementSize arrangementSize) {
                itemPrice.setText(arrangementSize.getPrice() + currencyName);
            }
        });

        traysRecyclerView = findViewById(R.id.arrangement_trays_recycler_view);
        GridLayoutManager layoutManager1 = new GridLayoutManager(this,1);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        traysRecyclerView.setLayoutManager(layoutManager1);
        itemDetailsViewModel.getAllTrays(arrangement.getId()).observe(this, new Observer<ArrayList<Tray>>() {
            @Override
            public void onChanged(ArrayList<Tray> trays) {

                if(trays.size()==0){
                    traysRecyclerView.setVisibility(View.GONE);
                }else{
                    ArrangementTraysAdapter arrangementTraysAdapter = new ArrangementTraysAdapter(trays, ItemDetailsActivity.this);
                    traysRecyclerView.setAdapter(arrangementTraysAdapter);
                    arrangementTraysAdapter.notifyDataSetChanged();
                }

            }
        });

    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        toolbar.setElevation(0);
        getSupportActionBar().setTitle("");


        ImageView shoppingCartAction = toolbar.findViewById(R.id.toolbar_shopping_cart);

        shoppingCartAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemDetailsActivity.this, MyCartActivity.class);
                startActivity(intent);
            }
        });

        ImageView backArrowAction = toolbar.findViewById(R.id.toolbar_back_arrow);
        backArrowAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public void selectItemSizeCall(Arrangement.ArrangementSize arrangementSize) {
        itemDetailsViewModel.setSelectedItemSize(arrangementSize);
    }

    @Override
    public void selectTrayCall(Tray tray) {
        if(tray == null){
            itemDetailsViewModel.setIsTraySelected(false);
        }else{
            Toast.makeText(this,tray.getName(), Toast.LENGTH_SHORT).show();
            itemDetailsViewModel.setIsTraySelected(true);
            itemDetailsViewModel.setSelectedTray(tray);
        }
    }

    public void showAlertDialogButtonClicked() {

        final Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.add_to_cart_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        TextView tvArrangementName = dialog.findViewById(R.id.cart_item_arrangement_name);
        TextView tvArrangementPrice = dialog.findViewById(R.id.cart_item_arrangement_price);
        final EditText edArrangementCount = dialog.findViewById(R.id.item_cart_arrangement_number);
        ImageView imArrangementImage = dialog.findViewById(R.id.cart_item_arrangement_image);

        TextView tvTrayName = dialog.findViewById(R.id.cart_item_tray_name);
        TextView tvTrayPrice = dialog.findViewById(R.id.cart_item_tray_price);
        final EditText edTrayCount = dialog.findViewById(R.id.item_cart_trays_number);


        final String arrangmentName = arrangement.getName();
        final String arrangmentImageUrl = arrangement.getImage_url();
        String arrangmentPrice = itemDetailsViewModel.getSelectedItemSize().getValue().getPrice() + currencyName;

        dialog.show();

        tvArrangementName.setText(arrangmentName);
        tvArrangementPrice.setText(arrangmentPrice);
        edArrangementCount.setText(arrangementCount+"");
        Glide.with(this)
                .load(arrangmentImageUrl)
                .placeholder(R.drawable.ic_image_black_24dp)
                .centerCrop()
                .into(imArrangementImage);


        if(itemDetailsViewModel.getIsTraySelected()){
                Tray tray = itemDetailsViewModel.getSelectedTray().getValue();
                tvTrayName.setText(tray.getName());
                tvTrayPrice.setText(tray.getPrice() + currencyName);
                edTrayCount.setText(trayCount+"");

            dialog.findViewById(R.id.item_cart_tray_plus).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    trayCount++;
                    edTrayCount.setText(trayCount+"");
                }
            });

            dialog.findViewById(R.id.item_cart_tray_minus).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(arrangementCount>1){
                        trayCount--;
                        edTrayCount.setText(trayCount+"");
                    }
                }
            });
        }else {
            dialog.findViewById(R.id.cardView1).setVisibility(View.GONE);
            dialog.findViewById(R.id.textview8).setVisibility(View.GONE);
        }

        dialog.findViewById(R.id.cart_item_arrangement_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrangementCount++;
                edArrangementCount.setText(arrangementCount+"");
            }
        });

        dialog.findViewById(R.id.cart_item_arrangement_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrangementCount>1){
                    arrangementCount--;
                    edArrangementCount.setText(arrangementCount+"");
                }
            }
        });

        edArrangementCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0)
                    arrangementCount = Integer.valueOf(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        edTrayCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0)
                    trayCount = Integer.valueOf(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        dialog.findViewById(R.id.confirm_add_to_cart_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MznCart.getINSTANCE().addArrangement(new ItemInCart(
                        itemDetailsViewModel.getSelectedItemSize().getValue().getId(),
                        arrangmentName,
                        itemDetailsViewModel.getSelectedItemSize().getValue().getPrice(),
                        arrangementCount,
                        "",
                        arrangmentImageUrl
                ));

                if (itemDetailsViewModel.getIsTraySelected()){
                    Tray selectedTray = itemDetailsViewModel.getSelectedTray().getValue();
                    MznCart.getINSTANCE().addTray(new ItemInCart(
                            selectedTray.getId(),
                            selectedTray.getName(),
                            selectedTray.getPrice(),
                            trayCount,
                            "",
                            selectedTray.getImage_url()
                    ));
                }

                Log.v("********** arrangement:", MznCart.getINSTANCE().getArrangementsList().size()+"");
                Log.v("********** tray:", MznCart.getINSTANCE().getTraysList().size()+"");

                dialog.dismiss();

            }


        });


    }

}
