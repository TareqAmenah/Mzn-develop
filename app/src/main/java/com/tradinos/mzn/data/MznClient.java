package com.tradinos.mzn.data;

import com.tradinos.mzn.pojo.SigninPojo.SinginModel;
import com.tradinos.mzn.pojo.SigninPojo.SinginResponseModel;
import com.tradinos.mzn.pojo.getAllTraysPojo.GetAllTraysResponseModel;
import com.tradinos.mzn.pojo.getArrangementsOrders.GetArrangementsOrdersResponse;
import com.tradinos.mzn.pojo.getArrangementsPojo.GetArrangementsResponse;
import com.tradinos.mzn.pojo.getFormData.GetFormDataResponse;
import com.tradinos.mzn.pojo.getOrderDetails.GetOrderDetailsResponse;
import com.tradinos.mzn.pojo.setOrderPojo.SetOrderModel;
import com.tradinos.mzn.pojo.setOrderPojo.SetOrderResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MznClient {

    // ********************************* Add base url here ******************************
    private static MznClient INSTANCE;
    private MznInterface mznInterface;


    public MznClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        mznInterface = retrofit.create(MznInterface.class);
    }

    public static MznClient getINSTANCE() {

        if(INSTANCE == null)
            INSTANCE = new MznClient();

        return INSTANCE;
    }

    public Call<SinginResponseModel> signinCall(SinginModel singinModel){

        return mznInterface.signin(singinModel);
    }

    public Call<GetArrangementsResponse> getArrangementsCall(){
        return mznInterface.getArrangements();
    }

    public Call<GetAllTraysResponseModel> getAllTraysCall(int arrangementId){
        return mznInterface.getAllTrays("json", arrangementId);
    }

    public Call<GetFormDataResponse> getFormDataCall(){
        return mznInterface.getFormData();
    }

    public Call<SetOrderResponse> setOrderCall(String headerToken, SetOrderModel setOrderModel){

        return mznInterface.setOrder(headerToken, setOrderModel);
    }

    public Call<GetArrangementsOrdersResponse> getArrangementsOrdersCall(String headerToken, int userId){
        return mznInterface.getArrangementsOrders(headerToken,"json", userId);
    }

    public Call<GetOrderDetailsResponse> getOrderDetailsCall(String headerToken, int userId, int orderId){
        return mznInterface.getOrderDetails(headerToken, "json", userId, orderId);
    }

}
