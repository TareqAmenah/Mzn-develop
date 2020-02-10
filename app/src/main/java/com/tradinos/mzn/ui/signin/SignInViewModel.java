package com.tradinos.mzn.ui.signin;

import com.tradinos.mzn.data.MznClient;
import com.tradinos.mzn.models.User;
import com.tradinos.mzn.pojo.SigninPojo.SinginResponseModel;
import com.tradinos.mzn.pojo.SigninPojo.SinginModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInViewModel extends ViewModel {

    private MutableLiveData<User> user = new MutableLiveData<>();
    private MutableLiveData<String> onFailureMessage = new MutableLiveData<>();



    public MutableLiveData<User> signin(SinginModel singinModel){

        MznClient.getINSTANCE().signinCall(singinModel).enqueue(new Callback<SinginResponseModel>() {
            @Override
            public void onResponse(Call<SinginResponseModel> call, Response<SinginResponseModel> response) {
                if (response.body().getStatus()){
                    User usertest = response.body().getData().getUser();
                    user.setValue(usertest);
                }else{
                    onFailureMessage.setValue(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<SinginResponseModel> call, Throwable t) {
                onFailureMessage.setValue(t.getMessage());
            }
        });
        return user;
    }

    public MutableLiveData<String> getOnFailureMessage() {
        return onFailureMessage;
    }
}
