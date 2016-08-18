package com.example.zhewang.daggermigratetest.modules;

import android.content.Context;

import com.example.zhewang.daggermigratetest.MockPreferences;
import com.example.zhewang.daggermigratetest.feature_a.TextService;
import com.example.zhewang.daggermigratetest.feature_a.TextServiceMock;
import com.example.zhewang.daggermigratetest.feature_a.TextServiceNetwork;
import com.example.zhewang.daggermigratetest.scopes.PerActivity;
import com.example.zhewang.daggermigratetest.views.TextFragment;

import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Module for {@link TextService}
 */
@Module/*(
        injects = TextFragment.class,
        library = true,
        complete = false
)*/
public class TextServiceModule {

    @Provides
    MockPreferences providesMockPreferences(Context context){
        return new MockPreferences(context);
    }


    @Provides
    @PerActivity
    TextService providesTextService(MockPreferences preferences,
                                    @Named("network") Provider<TextService> networkImpl,
                                    @Named("mock") Provider<TextService> mockImpl) {
        return preferences.getMockValue() ? mockImpl.get() : networkImpl.get();
    }


    @Provides
    @Named("network")
    @PerActivity
    TextService providesTextServiceNetwork(TextServiceNetwork network) {
        return network;
    }


    @Provides
    @Named("mock")
    @PerActivity
    TextService providesTextServiceMock(TextServiceMock mock) {
        return mock;
    }
}
