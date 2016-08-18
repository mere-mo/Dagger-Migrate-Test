package com.example.zhewang.daggermigratetest.feature_b;

import com.example.zhewang.daggermigratetest.R;
import com.example.zhewang.daggermigratetest.scopes.PerActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by zhe.wang on 8/2/16.
 */
@PerActivity
public class ImageServiceNetwork implements ImageService {
    @Inject
    public ImageServiceNetwork(){}

    @Override
    public int getImageResource() {
        return R.mipmap.ic_launcher;
    }
}
