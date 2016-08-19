package com.example.zhewang.daggermigratetest;


import android.content.Context;

import com.example.zhewang.daggermigratetest.components.AppComponent;
import com.example.zhewang.daggermigratetest.components.DaggerAppComponent;
import com.example.zhewang.daggermigratetest.components.DaggerImageServiceComponent;
import com.example.zhewang.daggermigratetest.components.DaggerTextServiceComponent;
import com.example.zhewang.daggermigratetest.components.ImageServiceComponent;
import com.example.zhewang.daggermigratetest.components.TextServiceComponent;
import com.example.zhewang.daggermigratetest.modules.AppModule;

/**
 * Created by zhe.wang on 8/1/16.
 */
public class Services {
    private Services() {}

    /** internal reference of object graph generated via {@link #initialize(Object)}} **/
//    private static ObjectGraph sObjectGraph;

    /**
     * initialize dagger with module-objects and saves object graph. This will overwrite existing intializations.
     * Please be aware that services already injected won't be affected by this change.
     * @param module instances of module-class (classes annotated with {@link dagger.Module})
     * @return generated object graph
     */
//    public static synchronized ObjectGraph initialize(Object module) {
//        sObjectGraph = ObjectGraph.create(module);
//        return sObjectGraph;
//    }

    /**
     * get dagger object graph
     * @return dagger object graph
     */
//    public static ObjectGraph getGlobalGraph() {
//        return sObjectGraph;
//    }

    private static AppComponent mAppComponent;
    private static ImageServiceComponent mImageServiceComponent;
    private static TextServiceComponent mTextServiceComponent;

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static ImageServiceComponent getImageServiceComponent() {
        mImageServiceComponent = DaggerImageServiceComponent.builder()
                .appComponent(getAppComponent())
                .build();
        return mImageServiceComponent;
    }

    public static TextServiceComponent getTextServiceComponent() {
        mTextServiceComponent = DaggerTextServiceComponent.builder()
                .appComponent(getAppComponent())
                .build();
        return mTextServiceComponent;
    }

    public static synchronized AppComponent init(Context context) {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(context))
                .build();
        return mAppComponent;
    }
}