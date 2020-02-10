package com.tradinos.mzn.ui.orderdetails;

import com.tradinos.mzn.data.MznClient;
import com.tradinos.mzn.models.OrderDetails;
import com.tradinos.mzn.pojo.getOrderDetails.GetOrderDetailsResponse;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetailsViewModel extends ViewModel {

    private MutableLiveData<OrderDetails> orderDetails;
    private MutableLiveData<String> onFailureMessage;

    public OrderDetailsViewModel() {
        orderDetails = new MutableLiveData<>();
        onFailureMessage = new MutableLiveData<>();
    }

    public MutableLiveData<OrderDetails> getOrderDetails(String headerToken, int userId, int orderId) {

        MznClient.getINSTANCE().getOrderDetailsCall(headerToken, userId, orderId).enqueue(new Callback<GetOrderDetailsResponse>() {
            @Override
            public void onResponse(Call<GetOrderDetailsResponse> call, Response<GetOrderDetailsResponse> response) {
                if(response.body().getStatus()){
                    orderDetails.setValue(response.body().getData());
                }else{
                    onFailureMessage.setValue(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<GetOrderDetailsResponse> call, Throwable t) {
                onFailureMessage.setValue(t.getMessage());
            }
        });

        return orderDetails;
    }

    public MutableLiveData<String> getOnFailureMessage() {
        return onFailureMessage;
    }
}
