package com.example.zhewang.daggermigratetest.components;

import com.example.zhewang.daggermigratetest.modules.ImageServiceModule;
import com.example.zhewang.daggermigratetest.scopes.PerActivity;
import com.example.zhewang.daggermigratetest.views.ImageFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hongling.a.mo on 8/18/16.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ImageServiceModule.class)
public interface ImageServiceComponent {
    void inject(ImageFragment imageFragment);
}
