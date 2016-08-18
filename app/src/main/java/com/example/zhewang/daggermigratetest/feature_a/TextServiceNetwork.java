package com.example.zhewang.daggermigratetest.feature_a;

import com.example.zhewang.daggermigratetest.scopes.PerActivity;

import javax.inject.Inject;

/**
 * Created by zhe.wang on 8/1/16.
 */
@PerActivity
public class TextServiceNetwork implements TextService {

    @Inject
    public TextServiceNetwork(){}

    @Override
    public String getText() {
        return "Network";
    }
}
