package com.jonah.jonahworld.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view,savedInstanceState);
        setListener();
        return view;
    }

    protected void setListener() {

    }

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected abstract int getLayoutId();

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            try {
                childFragmentManager.set(this, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
