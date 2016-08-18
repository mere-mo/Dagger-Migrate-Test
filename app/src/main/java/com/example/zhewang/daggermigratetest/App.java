package com.example.zhewang.daggermigratetest;

import android.app.Application;

import com.example.zhewang.daggermigratetest.modules.AppModule;

/**
 * Created by zhe.wang on 8/1/16.
 */
public class App extends Application {
    private static boolean sIsMock = false;

    @Override
    public void onCreate() {
        super.onCreate();
//        Services.initialize(getModule()).inject(this);
        Services.init(this).inject(this);
    }

    protected Object getModule(){
        return new AppModule(this);
    }

    public static void setMockType(boolean mock) {
        sIsMock = mock;
    }

    public static boolean isMockType() {
        return sIsMock;

    }
}
