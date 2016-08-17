package com.example.zhewang.daggermigratetest.modules;

import com.example.zhewang.daggermigratetest.TestApp;

import dagger.Module;

/**
 * Created by zhe.wang on 8/2/16.
 */
@Module(
        injects = TestApp.class,
        includes = AppModule.class,
        library = true,
        overrides = true
)
public class TestAppModule {
}