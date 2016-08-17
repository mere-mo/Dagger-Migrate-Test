package com.example.zhewang.daggermigratetest;

import com.example.zhewang.daggermigratetest.modules.TestAppModule;

/**
 * Created by zhe.wang on 8/2/16.
 */
public class TestApp extends App {
    @Override
    protected Object getModule() {
        return new TestAppModule();
    }
}
