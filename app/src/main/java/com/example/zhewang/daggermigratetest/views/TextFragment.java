package com.example.zhewang.daggermigratetest.views;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhewang.daggermigratetest.R;
import com.example.zhewang.daggermigratetest.feature_a.TextService;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zhe.wang on 8/2/16.
 */
public class TextFragment extends BaseFragment{
    public static final String TAG = TextFragment.class.getSimpleName();

    @Inject
    TextService mTextService;

    @InjectView(R.id.text_service)
    TextView mText;

    View mRootView;

    private static TextFragment mTextFragment;

    public static TextFragment newInstance() {
        if (mTextFragment == null) {
            mTextFragment = new TextFragment();
        }
        return mTextFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRootView =  View.inflate(getActivity(), R.layout.text_service, null);
        ButterKnife.inject(this, mRootView);
        mText.setText(String.format(getString(R.string.mock_type_text), mTextService.getText()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return mRootView;
    }
}
