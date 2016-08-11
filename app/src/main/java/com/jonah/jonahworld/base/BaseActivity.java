package com.jonah.jonahworld.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addConfig();
        setContentView(getContentView());
        if (getIntent() != null) {
            handleIntent(getIntent());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        //super.onSaveInstanceState(outState, outPersistentState);
    }

    private void addConfig() {
        getWindow().addFlags(Window.FEATURE_NO_TITLE);
    }

    protected  void handleIntent(Intent intent){}

    protected abstract int getContentView();
}
