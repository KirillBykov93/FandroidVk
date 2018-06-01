package com.bykov.kirill.fandroidvk.di.module;

import com.bykov.kirill.fandroidvk.rest.RestClient;
import com.bykov.kirill.fandroidvk.rest.api.WallApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Кирилл on 23.04.2018.
 */
@Module
public class RestModule {

    private RestClient restClient;

    public RestModule() {
        restClient = new RestClient();
    }

    @Singleton
    @Provides
    public RestClient provideRestClient() {
        return restClient;
    }

    @Singleton
    @Provides
    public WallApi provideWallApi() {
        return restClient.createService(WallApi.class);
    }
}
