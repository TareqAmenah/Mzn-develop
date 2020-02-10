package com.tradinos.mzn.ui.orders;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tradinos.mzn.R;
import com.tradinos.mzn.data.MznUser;
import com.tradinos.mzn.models.ArrangementOrder;
import com.tradinos.mzn.models.User;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArrangementsOrdersFragment extends Fragment {


    OrdersViewModel ordersViewModel;
    private RecyclerView recyclerView;
    private View progressLayout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_arrangements_orders, container, false);
        recyclerView = root.findViewById(R.id.arrangements_orders_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        progressLayout = root.findViewById(R.id.progress_layout);

        ordersViewModel = ViewModelProviders.of(this).get(OrdersViewModel.class);

        try {
            User user = MznUser.getINSTANCE().getMyUser(getActivity());
            int userId  = user.getId();
            String token = user.getToken();
            String headerToken = "Bearer " + token;

            ordersViewModel.getArrangementsOrdersList(headerToken, userId).observe(this, new Observer<ArrayList<ArrangementOrder>>() {
                @Override
                public void onChanged(ArrayList<ArrangementOrder> arrangementOrders) {
                    try {
                        ArrangementsOrdersAdapter arrangementsOrdersAdapter = new ArrangementsOrdersAdapter(arrangementOrders, getContext());
                        recyclerView.swapAdapter(arrangementsOrdersAdapter, true);

                    }catch (Exception e){
                        Log.d("*********", e.getMessage());
                    }
                    progressLayout.setVisibility(View.GONE);
                }
            });


        } catch (MznUser.UserNotFoundException e) {
            e.printStackTrace();
        }


        ordersViewModel.getOnFailureMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                progressLayout.setVisibility(View.GONE);
            }
        });

        return root;
    }



}
