package com.example.zhewang.daggermigratetest;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by zhe.wang on 8/2/16.
 */
public class MockPreferences {
    private static final String PREF_NAME = "mock_pref";
    private static final String MOCK_KEY = "mock_value";
    private SharedPreferences mPref;

    @Inject
    public MockPreferences(Context context){
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setMockValue(boolean isMock){
        SharedPreferences.Editor editor = mPref.edit();
        editor.putBoolean(MOCK_KEY, isMock);
        editor.apply();
    }

    public boolean getMockValue(){
        return mPref.getBoolean(MOCK_KEY, false);
    }


}
