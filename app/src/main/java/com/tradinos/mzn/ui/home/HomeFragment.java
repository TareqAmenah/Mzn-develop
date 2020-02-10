package com.tradinos.mzn.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tradinos.mzn.R;
import com.tradinos.mzn.data.MznUser;
import com.tradinos.mzn.models.Category;
import com.tradinos.mzn.models.FormData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView categoriesRecyclerView;
    private View progressLayout;
    private TextView logOutTextView;
    private LogOutCallBack logOutCallBack;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        progressLayout = root.findViewById(R.id.progress_layout);
        logOutTextView = root.findViewById(R.id.log_out_text_view);

        progressLayout.setVisibility(View.VISIBLE);
        logOutCallBack = (LogOutCallBack)getActivity();

        categoriesRecyclerView = root.findViewById(R.id.categories_recycler_view);
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        homeViewModel.getCategoriesListLiveData().observe(this, new Observer<ArrayList<Category>>() {
            @Override
            public void onChanged(ArrayList<Category> categories) {
                CategoriesAdapter categoriesAdapter = new CategoriesAdapter(categories, getContext());
                categoriesRecyclerView.setAdapter(categoriesAdapter);

                progressLayout.setVisibility(View.GONE);
            }
        });

        homeViewModel.getFormData().observe(this, new Observer<FormData>() {
            @Override
            public void onChanged(FormData formData) {
                MznUser.getINSTANCE().setFormData(formData);
                Toast.makeText(getActivity(), "Set form data done!", Toast.LENGTH_SHORT).show();
                progressLayout.setVisibility(View.GONE);
            }
        });

        logOutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOutCallBack.logOutCall();
            }
        });

        return root;
    }


    public interface LogOutCallBack{
        void logOutCall();
    }
}