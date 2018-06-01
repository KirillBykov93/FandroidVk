package com.bykov.kirill.fandroidvk.di.component;

import com.bykov.kirill.fandroidvk.di.module.ApplicationModule;
import com.bykov.kirill.fandroidvk.di.module.ModuleManager;
import com.bykov.kirill.fandroidvk.di.module.RestModule;
import com.bykov.kirill.fandroidvk.ui.activity.BaseActivity;
import com.bykov.kirill.fandroidvk.ui.activity.MainActivity;
import com.bykov.kirill.fandroidvk.ui.fragment.NewsFeedFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Кирилл on 23.04.2018.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ModuleManager.class, RestModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);
    void inject(MainActivity mainActivity);

    void inject(NewsFeedFragment newsFeedFragment);


}
