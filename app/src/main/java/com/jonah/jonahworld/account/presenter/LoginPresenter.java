package com.jonah.jonahworld.account.presenter;

import android.content.Context;

import com.jonah.jonahworld.R;
import com.jonah.jonahworld.account.fragment.LoginFragment;
import com.jonah.jonahworld.account.view.LoginView;
import com.jonah.jonahworld.base.BasePresenter;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public class LoginPresenter implements BasePresenter<LoginFragment>{
    private LoginView mView;
    private Context context;

    public LoginPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void attachView(LoginFragment baseView) {
        mView = baseView;
    }

    @Override
    public void detachView() {
        mView = null;
    }


    public void loginApp(){
        if (mView != null) {
            if (mView.checkAccount()){
                mView.showMessage(context.getResources().getString(R.string.username_error));
            }
            if (mView.checkPassword()){
                mView.showMessage(context.getResources().getString(R.string.password_error));
            }
        }
    }
}
