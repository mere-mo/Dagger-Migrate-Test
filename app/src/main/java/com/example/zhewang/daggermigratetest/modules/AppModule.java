package com.example.zhewang.daggermigratetest.modules;

import android.content.Context;

import com.example.zhewang.daggermigratetest.MockPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Application module which includes all other modules
 */
@Module
        /*(
        includes = {TextServiceModule.class, ImageServiceModule.class},
        injects = {App.class, MainActivity.class},
        library = true
)*/
public class AppModule {
    private final Context mContext;

    public AppModule() {
        mContext = null;
    }

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides @Singleton
    Context providesContext() {
        return mContext.getApplicationContext();
    }

    @Provides @Singleton
    MockPreferences providesMockPreferences() {
        return new MockPreferences(mContext);
    }
}
