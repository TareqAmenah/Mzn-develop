package com.tradinos.mzn.util;

import com.tradinos.mzn.data.MznClient;
import com.tradinos.mzn.models.ArrangementOrder;
import com.tradinos.mzn.pojo.getArrangementsOrders.GetArrangementsOrdersResponse;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyOrdersRepo {

    private static MyOrdersRepo INSTANCE;
    private MutableLiveData<ArrayList<ArrangementOrder>> arrangementsOrdersList;
    private MutableLiveData<String> onFailureMessage;


    public MyOrdersRepo() {
        arrangementsOrdersList = new MutableLiveData<>();
        onFailureMessage = new MutableLiveData<>();
    }

    public static MyOrdersRepo getINSTANCE() {

        if(INSTANCE == null){
            INSTANCE = new MyOrdersRepo();
        }

        return INSTANCE;
    }


    public MutableLiveData<ArrayList<ArrangementOrder>> getArrangementsOrdersList(String headerToken, int userId){

        MznClient.getINSTANCE().getArrangementsOrdersCall(headerToken, userId).enqueue(new Callback<GetArrangementsOrdersResponse>() {
            @Override
            public void onResponse(Call<GetArrangementsOrdersResponse> call, Response<GetArrangementsOrdersResponse> response) {
                if(response.body().getStatus()){
                    arrangementsOrdersList.setValue(response.body().getData());
                }else {
                    onFailureMessage.setValue(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<GetArrangementsOrdersResponse> call, Throwable t) {
                onFailureMessage.setValue(t.getMessage());
            }
        });

        return arrangementsOrdersList;
    }

    public MutableLiveData<String> getOnFailureMessage(){
        return onFailureMessage;
    }


    public boolean ChangeOrderStatus(int orderId, int newStatus){

        ArrayList<ArrangementOrder> newArrangementsOrders = arrangementsOrdersList.getValue();

        if(newArrangementsOrders == null)
            return false;

        if(newArrangementsOrders.size() == 0)
            return false;

        for (ArrangementOrder newArrangementsOrder : newArrangementsOrders) {
            if(newArrangementsOrder.getId() == orderId){
                newArrangementsOrder.setStatus(newStatus);
                arrangementsOrdersList.postValue(newArrangementsOrders);
                return true;
            }
        }
        return false;
    }

}
