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

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MznInterface {

    @POST("signin")
    public Call<SinginResponseModel> signin(@Body SinginModel singinModel);

    @GET("get_arrangments?format=json")
    public Call<GetArrangementsResponse> getArrangements();

    @GET("get_all_trays")
    public Call<GetAllTraysResponseModel> getAllTrays(@Query("format") String format,
                                                      @Query("arrangment_id") int arrangment_id);

    @GET("get_form_data?format=json")
    public Call<GetFormDataResponse> getFormData();

    @POST("set_order?format=json")
    @Headers("Content-Type: application/json")
    public Call<SetOrderResponse> setOrder(@Header("Authorization") String token,
                                           @Body SetOrderModel setOrderModel);

    @GET("get_all_orders")
    public Call<GetArrangementsOrdersResponse> getArrangementsOrders(@Header("Authorization") String token,
                                                                     @Query("format") String format,
                                                                     @Query("user_id") int user_id);

    @GET("get_order_detail")
    public Call<GetOrderDetailsResponse> getOrderDetails(@Header("Authorization") String token,
                                                         @Query("format") String format,
                                                         @Query("user_id") int user_id,
                                                         @Query("order_id") int order_id);
}
