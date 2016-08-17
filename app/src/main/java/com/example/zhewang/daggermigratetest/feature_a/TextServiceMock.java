package com.example.zhewang.daggermigratetest.feature_a;

import javax.inject.Inject;

/**
 * Created by zhe.wang on 8/1/16.
 */
public class TextServiceMock implements TextService {
    @Inject
    public TextServiceMock(){}

    @Override
    public String getText() {
        return "Mock";
    }
}
