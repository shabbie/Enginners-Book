package com.example.abhishekkoranne.engineersbook;

/**
 * Created by Abhishek Koranne on 04-03-2018.
 */

import com.google.gson.JsonElement;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface APIManager {
    @FormUrlEncoded
    @POST(Constant.URL_LOGIN)
    Call<JsonElement> login(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Constant.URL_REGISTER)
    Call<JsonElement> register(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Constant.URL_GET_DETAIL)
    Call<JsonElement> getDetails(@FieldMap Map<String, String> params);

    // Add all your api calls here...
}
