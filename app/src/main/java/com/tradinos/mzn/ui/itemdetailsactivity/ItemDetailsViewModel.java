package com.tradinos.mzn.ui.itemdetailsactivity;

import com.tradinos.mzn.data.MznClient;
import com.tradinos.mzn.models.Arrangement;
import com.tradinos.mzn.models.Tray;
import com.tradinos.mzn.pojo.getAllTraysPojo.GetAllTraysResponseModel;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDetailsViewModel extends ViewModel {

    private MutableLiveData<Arrangement.ArrangementSize> selectedItemSize;
    private MutableLiveData<Tray> selectedTray;
    private Arrangement arrangement;
    private MutableLiveData<ArrayList<Tray>> traysList;
    private MutableLiveData<String> onFailureMessage;
    private MutableLiveData<Boolean> isTraySelected;

    public ItemDetailsViewModel() {
        selectedItemSize = new MutableLiveData<>();
        traysList = new MutableLiveData<>();
        onFailureMessage = new MutableLiveData<>();
        selectedTray = new MutableLiveData<>();
        isTraySelected = new MutableLiveData<>();
        isTraySelected.setValue(false);
    }

    public MutableLiveData<String> getOnFailureMessage() {
        return onFailureMessage;
    }

    public void setArrangement(Arrangement arrangement) {
        this.arrangement = arrangement;
        selectedItemSize.setValue(arrangement.getSizes().get(0));
    }

    public void setSelectedItemSize(Arrangement.ArrangementSize selectedItemSize) {
        this.selectedItemSize.setValue(selectedItemSize);
    }

    public MutableLiveData<Arrangement.ArrangementSize> getSelectedItemSize() {
        return selectedItemSize;
    }

    public MutableLiveData<Tray> getSelectedTray() {
        return selectedTray;
    }

    public void setSelectedTray(Tray selectedTray) {
        this.selectedTray.setValue(selectedTray);
    }

    public MutableLiveData<ArrayList<Tray>> getAllTrays(int arrangementId){

        MznClient.getINSTANCE().getAllTraysCall(arrangementId).enqueue(new Callback<GetAllTraysResponseModel>() {
            @Override
            public void onResponse(Call<GetAllTraysResponseModel> call, Response<GetAllTraysResponseModel> response) {

                if(response.body().isStatus()){
                    traysList.setValue(response.body().getData());
                }else {
                    onFailureMessage.setValue(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<GetAllTraysResponseModel> call, Throwable t) {
                onFailureMessage.setValue(t.getMessage());
            }
        });

        return traysList;
    }

    public boolean getIsTraySelected() {
        return isTraySelected.getValue();
    }

    public void setIsTraySelected(boolean isTraySelected) {
        this.isTraySelected.setValue(isTraySelected);
    }
}
