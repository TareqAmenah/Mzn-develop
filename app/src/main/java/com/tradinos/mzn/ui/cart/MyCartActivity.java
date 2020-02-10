package com.tradinos.mzn.ui.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tradinos.mzn.R;
import com.tradinos.mzn.data.MznCart;
import com.tradinos.mzn.models.ItemInCart;
import com.tradinos.mzn.ui.checkout.CheckOutArrangementActivity;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyCartActivity extends AppCompatActivity implements ItemInCartAdapter.CalculateTotalCallBack{

    TextView totalPriceTextView;
    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        setupToolbar();

        totalPriceTextView = findViewById(R.id.total_price_text_view);
        continueButton = findViewById(R.id.continue_button);

        ArrayList<ItemInCart> arrangementInCartList = MznCart.getINSTANCE().getArrangementsList();
        ArrayList<ItemInCart> trayInCartList = MznCart.getINSTANCE().getTraysList();

        RecyclerView arrangementRecyclerView = findViewById(R.id.cart_arrangements_recycler_view);
        ItemInCartAdapter arrangementAdapter = new ItemInCartAdapter(arrangementInCartList, this);
        arrangementRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrangementRecyclerView.setAdapter(arrangementAdapter);


        RecyclerView trayRecyclerView = findViewById(R.id.cart_trays_recycler_view);
        ItemInCartAdapter trayAdapter = new ItemInCartAdapter(trayInCartList, this);
        trayRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        trayRecyclerView.setAdapter(trayAdapter);

        calculateTotalCall();

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyCartActivity.this, CheckOutArrangementActivity.class));
            }
        });



    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        toolbar.setElevation(0);
        TextView toolbar_title = toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText("My Cart");



        ImageView shoppingCartAction = toolbar.findViewById(R.id.toolbar_shopping_cart);
        shoppingCartAction.setVisibility(View.INVISIBLE);

        ImageView backArrowAction = toolbar.findViewById(R.id.toolbar_back_arrow);
        backArrowAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public void calculateTotalCall() {
        String currencyName = getString(R.string.currency_name);
        totalPriceTextView.setText(MznCart.getINSTANCE().getTotal() + currencyName);
    }
}
