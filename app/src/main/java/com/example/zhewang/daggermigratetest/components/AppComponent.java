package com.example.zhewang.daggermigratetest.components;

import android.content.Context;

import com.example.zhewang.daggermigratetest.App;
import com.example.zhewang.daggermigratetest.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hongling.a.mo on 8/18/16.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(App app);
    Context getContext();
}
