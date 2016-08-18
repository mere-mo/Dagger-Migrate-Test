package com.example.zhewang.daggermigratetest.views;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.zhewang.daggermigratetest.MockPreferences;
import com.example.zhewang.daggermigratetest.R;
import com.example.zhewang.daggermigratetest.Services;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhe.wang on 8/2/16.
 */
public class MainActivity extends BaseActivity {
    @Inject
    MockPreferences mPref;

    private TextFragment mTextFragment;

    private ImageFragment mImageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.inject(this);

        mTextFragment = TextFragment.newInstance();
        mImageFragment = ImageFragment.newInstance();
        Services.getTextServiceComponent().inject(mTextFragment);
        Services.getImageServiceComponent().inject(mImageFragment);
    }

    @OnClick(R.id.text_service_button)
    public void onTextServiceClick() {
//        TextFragment fragment = TextFragment.newInstance();
//        fragment.show(getFragmentManager(), TextFragment.TAG);
        mTextFragment.show(getFragmentManager(), TextFragment.TAG);
    }

    @OnClick(R.id.image_service_button)
    public void onImageServiceClick() {
//        ImageFragment fragment = ImageFragment.newInstance();
//        fragment.show(getFragmentManager(), ImageFragment.TAG);
        mImageFragment.show(getFragmentManager(), ImageFragment.TAG);
    }

    @OnClick(R.id.switch_button)
    public void onSwitchButtonClick() {
        mPref.setMockValue(!mPref.getMockValue());
        restartApp();
    }

    private void restartApp(){
        Intent launchIntent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent intent = PendingIntent.getActivity(this.getBaseContext(), 0, launchIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager manager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        manager.set(AlarmManager.RTC, System.currentTimeMillis() + 100L, intent);
        finish();
        System.exit(0);
    }
}
