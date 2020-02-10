package com.tradinos.mzn.ui.orders;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.tradinos.mzn.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class OrdersActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem arrangementsOrderTabItem;
    TabItem giftsOrderTabItem;
    ViewPager viewPager;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        getSupportActionBar().setTitle(getString(R.string.menu_my_orders));
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        setupUi();

    }

    private void setupUi(){

        tabLayout = findViewById(R.id.tablayout);
        arrangementsOrderTabItem = findViewById(R.id.tabitem_arrangements_orders);
        giftsOrderTabItem = findViewById(R.id.tabitem_gifts_orders);
        viewPager = findViewById(R.id.viewpager);
        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setupWithViewPager(viewPager);
    }
}
