package com.example.zhewang.daggermigratetest.feature_b;

import com.example.zhewang.daggermigratetest.R;

import javax.inject.Inject;

/**
 * Mock implementation of {@link ImageService}
 */
public class ImageServiceMock implements ImageService{

    @Inject
    public ImageServiceMock(){}

    @Override
    public int getImageResource() {
        return R.mipmap.ic_mail;
    }
}
