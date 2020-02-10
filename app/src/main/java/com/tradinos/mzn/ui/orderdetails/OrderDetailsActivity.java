package com.tradinos.mzn.ui.orderdetails;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tradinos.mzn.R;
import com.tradinos.mzn.data.MznUser;
import com.tradinos.mzn.models.OrderDetails;
import com.tradinos.mzn.models.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrderDetailsActivity extends AppCompatActivity {

    OrderDetailsViewModel orderDetailsViewModel;
    int orderNumber;
    int orderId;
    TextView orderNumberTexView, orderStatus, orderDate, orderTime, orderAddress, orderTotal, orderSubtotal, orderDeliveryFee;
    RecyclerView orderDetailsItemsRecyclerView;
    private View progressLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        progressLayout = findViewById(R.id.progress_layout);

        orderId = getIntent().getIntExtra("orderId", 0);

        getSupportActionBar().setTitle("Order " + orderId + " Details");

        orderDetailsViewModel = ViewModelProviders.of(this).get(OrderDetailsViewModel.class);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupUi();
        getData();


    }

    private void getData() {

        try {
            User user = MznUser.getINSTANCE().getMyUser(this);
            String headerToken = "Bearer " + user.getToken();
            int userId = user.getId();
            final String currencyName = getString(R.string.currency_name);
            orderDetailsViewModel.getOrderDetails(headerToken, userId, orderId).observe(this, new Observer<OrderDetails>() {
                @Override
                public void onChanged(OrderDetails orderDetails) {

                    String orderNumber = getString(R.string.order_number) + orderId;
                    orderNumberTexView.setText(orderNumber);

                    if(orderDetails.getStatus()==1)
                        orderStatus.setText(getString(R.string.approved) + "");
                    else
                        orderStatus.setText(getString(R.string.cancelled) + "");
                    String date = orderDetails.getCreated_date().substring(0, orderDetails.getCreated_date().indexOf(" ")+1);
                    orderDate.setText(date);

                    String timeBlock = MznUser.getINSTANCE().getFormData().getTime_blocks().get(orderDetails.getDelivery_time()).getAsString();
                    orderTime.setText(timeBlock);

                    orderAddress.setText(orderDetails.getArea());
                    orderSubtotal.setText(orderDetails.getSubtotal() + currencyName);
                    orderDeliveryFee.setText(orderDetails.getDelivery_fee() + currencyName);
                    orderTotal.setText(orderDetails.getTotal() + currencyName);

                    orderDetailsItemsRecyclerView.setAdapter(new OrderDetailsItemsAdapter(orderDetails, OrderDetailsActivity.this));

                    progressLayout.setVisibility(View.GONE);
                }
            });


        } catch (MznUser.UserNotFoundException e) {
            e.printStackTrace();
        }

        orderDetailsViewModel.getOnFailureMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(OrderDetailsActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void setupUi() {


        orderNumberTexView = findViewById(R.id.order_details_order_number);
        orderStatus = findViewById(R.id.order_details_order_status);
        orderDate = findViewById(R.id.order_details_order_date);
        orderTime = findViewById(R.id.order_details_order_time);
        orderTotal = findViewById(R.id.order_details_order_total_price);
        orderSubtotal = findViewById(R.id.order_details_order_subtotal_price);
        orderDeliveryFee = findViewById(R.id.order_details_order_delivery_fee);
        orderAddress = findViewById(R.id.order_details_order_address);

        orderDetailsItemsRecyclerView = findViewById(R.id.order_details_order_items_recycler_view);
        orderDetailsItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if(item.getItemId() == R.id.home)
//            finish();
//
//        return true;
//    }
}
