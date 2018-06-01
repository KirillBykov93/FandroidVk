package com.bykov.kirill.fandroidvk.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Кирилл on 23.04.2018.
 */

public class RestClient {
    private static final String VK_BASE_URL = "https://api.vk.com/method/";

    private Retrofit retrofit;

    public RestClient() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(VK_BASE_URL)
                .build();
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }


}
