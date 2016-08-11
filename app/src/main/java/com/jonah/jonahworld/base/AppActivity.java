package com.jonah.jonahworld.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.jonah.jonahworld.R;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public abstract class AppActivity extends MoreFragmentActivity {
    protected TextView tvTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText(getResources().getString(R.string.app_title));
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.fl_fragment_view;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_base;
    }
}
