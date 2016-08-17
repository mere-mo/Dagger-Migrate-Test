package com.example.zhewang.daggermigratetest.modules;

import com.example.zhewang.daggermigratetest.MockPreferences;
import com.example.zhewang.daggermigratetest.feature_b.ImageService;
import com.example.zhewang.daggermigratetest.feature_b.ImageServiceMock;
import com.example.zhewang.daggermigratetest.feature_b.ImageServiceNetwork;
import com.example.zhewang.daggermigratetest.views.ImageFragment;

import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhe.wang on 8/2/16.
 */
@Module(
        injects = ImageFragment.class,
        library = true,
        complete = false
)
public class ImageServiceModule {

    @Singleton
    @Provides
    ImageService providesImageService(MockPreferences preferences,
                                      @Named("network") Provider<ImageService> networkImpl,
                                      @Named("mock") Provider<ImageService> mockImpl) {
        return preferences.getMockValue() ? mockImpl.get() : networkImpl.get();
    }

    @Singleton
    @Provides
    @Named("network")
    ImageService providesImageServiceNetwork(ImageServiceNetwork network) {
        return network;
    }

    @Singleton
    @Provides
    @Named("mock")
    ImageService providesIamageServiceMock(ImageServiceMock mock) {
        return mock;
    }
}
