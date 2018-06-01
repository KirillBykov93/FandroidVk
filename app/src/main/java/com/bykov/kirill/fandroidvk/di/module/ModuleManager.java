package com.bykov.kirill.fandroidvk.di.module;

import com.bykov.kirill.fandroidvk.common.manager.MyFragmentManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Кирилл on 23.04.2018.
 */
@Module
public class ModuleManager {

    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager() {
        return new MyFragmentManager();
    }
}
