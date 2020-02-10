package com.tradinos.mzn.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.tradinos.mzn.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class SettingsFragment extends Fragment {

    private SettingsViewModel slideshowViewModel;
    private RadioGroup radioGroup;
    private ChangeLanguageCallBack changeLanguageCallBack;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        radioGroup = root.findViewById(R.id.radio_group);

        changeLanguageCallBack = (ChangeLanguageCallBack)getActivity();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch(i) {
                    case R.id.radio_english:
                        changeLanguageCallBack.changeLanguageCall("en");
                        break;
                    case R.id.radio_arabic:
                        changeLanguageCallBack.changeLanguageCall("ar");
                        break;
                }
            }
        });

        return root;
    }



    public interface ChangeLanguageCallBack{
        void changeLanguageCall(String s);
    }



}