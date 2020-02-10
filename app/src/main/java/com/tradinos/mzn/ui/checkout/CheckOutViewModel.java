package com.tradinos.mzn.ui.checkout;

import android.util.Log;

import com.tradinos.mzn.data.MznClient;
import com.tradinos.mzn.pojo.setOrderPojo.SetOrderModel;
import com.tradinos.mzn.pojo.setOrderPojo.SetOrderResponse;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckOutViewModel extends ViewModel {

    private MutableLiveData<String> onFailureMessage;
    private MutableLiveData<SetOrderResponse> setOrderResponse;


    public CheckOutViewModel() {
        onFailureMessage = new MutableLiveData<>();
        setOrderResponse = new MutableLiveData<>();
    }


    public MutableLiveData<String> getOnFailureMessage(){
        return onFailureMessage;
    }

    public MutableLiveData<SetOrderResponse> setOrder(String token, SetOrderModel setOrderModel){

        MznClient.getINSTANCE().setOrderCall(token, setOrderModel)
                .enqueue(new Callback<SetOrderResponse>() {
                    @Override
                    public void onResponse(Call<SetOrderResponse> call, Response<SetOrderResponse> response) {
                        setOrderResponse.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<SetOrderResponse> call, Throwable t) {
                        onFailureMessage.setValue(t.getMessage());
                        t.printStackTrace();
                        Log.e("********", t.getMessage());
                    }
                });

        return setOrderResponse;
    }

}
