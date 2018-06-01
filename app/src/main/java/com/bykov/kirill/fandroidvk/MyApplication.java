package com.bykov.kirill.fandroidvk;

import android.app.Application;

import com.bykov.kirill.fandroidvk.di.component.ApplicationComponent;
import com.bykov.kirill.fandroidvk.di.component.DaggerApplicationComponent;
import com.bykov.kirill.fandroidvk.di.module.ApplicationModule;
import com.vk.sdk.VKSdk;

/**
 * Created by Кирилл on 19.04.2018.
 */

public class MyApplication extends Application {
    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        VKSdk.initialize(this);
    }

    private void initComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
