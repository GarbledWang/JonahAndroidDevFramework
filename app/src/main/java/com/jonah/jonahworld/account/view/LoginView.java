package com.jonah.jonahworld.account.view;

import com.jonah.jonahworld.base.BaseView;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public interface LoginView extends BaseView{

    boolean checkAccount();

    boolean checkPassword();

    void showProgress();

    void hideProgress();

    void loginComplete();

    void showMessage(String msg);
}
