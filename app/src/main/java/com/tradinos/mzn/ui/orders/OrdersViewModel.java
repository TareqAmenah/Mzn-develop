package com.tradinos.mzn.ui.orders;

import com.tradinos.mzn.models.ArrangementOrder;
import com.tradinos.mzn.util.MyOrdersRepo;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrdersViewModel extends ViewModel {

    private MutableLiveData<ArrayList<ArrangementOrder>> arrangementsOrdersList;
    private MutableLiveData<String> onFailureMessage;

    private MyOrdersRepo myOrdersRepo;

    public OrdersViewModel() {
        arrangementsOrdersList = new MutableLiveData<>();
        onFailureMessage = new MutableLiveData<>();

        myOrdersRepo = MyOrdersRepo.getINSTANCE();
    }

    public MutableLiveData<ArrayList<ArrangementOrder>> getArrangementsOrdersList(String headerToken, int userId){

//        MznClient.getINSTANCE().getArrangementsOrdersCall(headerToken, userId).enqueue(new Callback<GetArrangementsOrdersResponse>() {
//            @Override
//            public void onResponse(Call<GetArrangementsOrdersResponse> call, Response<GetArrangementsOrdersResponse> response) {
//                if(response.body().getStatus()){
//                    arrangementsOrdersList.setValue(response.body().getData());
//                }else {
//                    onFailureMessage.setValue(response.body().getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<GetArrangementsOrdersResponse> call, Throwable t) {
//                onFailureMessage.setValue(t.getMessage());
//            }
//        });
//
//        return arrangementsOrdersList;

        return myOrdersRepo.getArrangementsOrdersList(headerToken, userId);
    }

    public MutableLiveData<String> getOnFailureMessage(){

//        return onFailureMessage;
        return myOrdersRepo.getOnFailureMessage();
    }

}
