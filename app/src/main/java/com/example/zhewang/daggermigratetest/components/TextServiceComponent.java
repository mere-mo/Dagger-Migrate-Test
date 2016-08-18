package com.example.zhewang.daggermigratetest.components;

import com.example.zhewang.daggermigratetest.modules.TextServiceModule;
import com.example.zhewang.daggermigratetest.scopes.PerActivity;
import com.example.zhewang.daggermigratetest.views.TextFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hongling.a.mo on 8/18/16.
 */
@PerActivity
@Component(dependencies = { AppComponent.class }, modules = { TextServiceModule.class })
public interface TextServiceComponent {
    void inject(TextFragment textFragment);
}
