package com.jonah.jonahworld.base;

import android.os.Bundle;
import android.view.KeyEvent;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public abstract class MoreFragmentActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportFragmentManager().getFragments() == null) {
            BaseFragment baseFragment = getFragmentView();
            if (getFragmentView() != null) {
                setupFragment(baseFragment);
            }
        }
    }

    protected void setupFragment(BaseFragment baseFragment){
        getSupportFragmentManager().beginTransaction()
        .replace(getFragmentContentId(),baseFragment,baseFragment.getClass().getSimpleName())
        .addToBackStack(baseFragment.getClass().getSimpleName())
        .commitAllowingStateLoss();
    }

    protected void removeFragment(){
        if (getSupportFragmentManager().getBackStackEntryCount() > 1){
            getSupportFragmentManager().popBackStack();
        }else {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (getSupportFragmentManager().getBackStackEntryCount() > 1){
                finish();
                return true;
            }else {
                getSupportFragmentManager().popBackStack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    protected abstract BaseFragment getFragmentView();

    protected abstract int getFragmentContentId();

}
