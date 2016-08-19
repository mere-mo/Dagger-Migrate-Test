package com.example.zhewang.daggermigratetest;

import android.app.Application;
import android.util.Log;

import com.example.zhewang.daggermigratetest.modules.AppModule;

/**
 * Created by zhe.wang on 8/1/16.
 */
public class App extends Application {
    private final static String TAG = "mohl";
    private static boolean sIsMock = false;

    @Override
    public void onCreate() {
        super.onCreate();
//        Services.initialize(getModule()).inject(this);
        Services.init(this).inject(this);
        Log.i(TAG, "====== This is from Dagger2 ======");
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
