package com.jonah.jonahworld.app;

import android.support.multidex.MultiDexApplication;

import com.jonah.data.service.DataLayer;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public class JonahApp extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        DataLayer.mContext = this;
    }

}
