package com.tradinos.mzn.ui.home;

import com.tradinos.mzn.data.MznClient;
import com.tradinos.mzn.data.MznUser;
import com.tradinos.mzn.models.Arrangement;
import com.tradinos.mzn.models.Category;
import com.tradinos.mzn.models.FormData;
import com.tradinos.mzn.pojo.getArrangementsPojo.GetArrangementsResponse;
import com.tradinos.mzn.pojo.getFormData.GetFormDataResponse;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> onFailureMessage;
    private MutableLiveData<ArrayList<Category>> categoriesListLiveData;
    private MutableLiveData<FormData> formDataMutableLiveData;

    public HomeViewModel() {
        onFailureMessage = new MutableLiveData<>() ;
        formDataMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<Category>> getCategoriesListLiveData(){

        categoriesListLiveData = new MutableLiveData<ArrayList<Category>>();
        final ArrayList<Category> categoryArrayList = new ArrayList<>();

        MznClient.getINSTANCE().getArrangementsCall().enqueue(new Callback<GetArrangementsResponse>() {
            @Override
            public void onResponse(Call<GetArrangementsResponse> call, Response<GetArrangementsResponse> response) {

                if(response.body().getStatus()){
                    categoryArrayList.add(new Category("Ready arrangement", "Pick an arrangement to be delivered to you", response.body().getData()));
                    categoryArrayList.add(new Category("Beautifying", "Beautifying your gifts: A gift-wrapping service", new ArrayList<Arrangement>()));

                }else {
                    categoryArrayList.add(new Category("Ready arrangement", "Pick an arrangement to be delivered to you", new ArrayList<Arrangement>()));
                    categoryArrayList.add(new Category("Beautifying", "Beautifying your gifts: A gift-wrapping service", new ArrayList<Arrangement>()));
                    onFailureMessage.setValue(response.body().getMessage());
                }
                categoriesListLiveData.setValue(categoryArrayList);
            }

            @Override
            public void onFailure(Call<GetArrangementsResponse> call, Throwable t) {
                categoryArrayList.add(new Category("Ready arrangement", "Pick an arrangement to be delivered to you", new ArrayList<Arrangement>()));
                categoryArrayList.add(new Category("Beautifying", "Beautifying your gifts: A gift-wrapping service", new ArrayList<Arrangement>()));
                categoriesListLiveData.setValue(categoryArrayList);
                onFailureMessage.setValue(t.getMessage());
            }
        });

        return categoriesListLiveData;
    }

    public MutableLiveData<FormData> getFormData(){

        FormData formData = MznUser.getINSTANCE().getFormData();
        if(formData != null){
            formDataMutableLiveData.setValue(formData);
            return formDataMutableLiveData;
        }

        MznClient.getINSTANCE().getFormDataCall().enqueue(new Callback<GetFormDataResponse>() {
            @Override
            public void onResponse(Call<GetFormDataResponse> call, Response<GetFormDataResponse> response) {
                if(response.body().getStatus()){

                    formDataMutableLiveData.setValue(response.body().getData());

                }else{
                    onFailureMessage.setValue(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<GetFormDataResponse> call, Throwable t) {
                onFailureMessage.setValue(t.getMessage());
            }
        });

        return formDataMutableLiveData;
    }

    public MutableLiveData<String> getOnFailureMessage() {
        return onFailureMessage;
    }
}