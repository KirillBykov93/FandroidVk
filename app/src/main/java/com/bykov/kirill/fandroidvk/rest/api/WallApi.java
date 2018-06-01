package com.bykov.kirill.fandroidvk.rest.api;



import com.bykov.kirill.fandroidvk.rest.module.response.GetWallResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Кирилл on 23.04.2018.
 */

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Call<GetWallResponse> get(@QueryMap Map<String, String> map);



}
