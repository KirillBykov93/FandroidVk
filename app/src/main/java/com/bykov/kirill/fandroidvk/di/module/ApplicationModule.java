package com.bykov.kirill.fandroidvk.di.module;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Кирилл on 23.04.2018.
 */
@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }


    @Singleton
    @Provides
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    Typeface provideGoogleTypeface(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "MaterialIcons-Regular.ttf");
    }
}
