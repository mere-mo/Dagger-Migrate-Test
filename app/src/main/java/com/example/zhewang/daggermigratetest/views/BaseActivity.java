package com.example.zhewang.daggermigratetest.views;

import android.support.v7.app.AppCompatActivity;

import com.example.zhewang.daggermigratetest.Services;

public class BaseActivity extends AppCompatActivity {
    public BaseActivity(){
        Services.getGlobalGraph().inject(this);
    }
}
