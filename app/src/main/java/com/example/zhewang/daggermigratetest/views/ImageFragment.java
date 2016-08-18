package com.example.zhewang.daggermigratetest.views;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zhewang.daggermigratetest.R;
import com.example.zhewang.daggermigratetest.feature_b.ImageService;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Fragment to show image
 */
public class ImageFragment extends BaseFragment {

    public static final String TAG = ImageFragment.class.getSimpleName();

    @Inject
    ImageService mImageService;

    @InjectView(R.id.image_service)
    ImageView mImage;

    private static ImageFragment mImageFragment;

    public static ImageFragment newInstance() {
        if (mImageFragment == null) {
            mImageFragment = new ImageFragment();
        }
        return mImageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_service, null);
        ButterKnife.inject(this, view);
        mImage.setImageResource(mImageService.getImageResource());

        return view;
    }
}
