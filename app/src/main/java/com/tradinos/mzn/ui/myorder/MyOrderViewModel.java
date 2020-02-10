package com.tradinos.mzn.ui.myorder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyOrderViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyOrderViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is my order fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}