package com.jonah.jonahworld.account.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jonah.jonahworld.R;
import com.jonah.jonahworld.account.presenter.LoginPresenter;
import com.jonah.jonahworld.account.view.LoginView;
import com.jonah.jonahworld.base.BaseFragment;
import com.jonah.jonahworld.util.RegexUtil;

/**
 * @author JonahWang
 *         Created by JonahWang on 2016/7/11.
 */
public class LoginFragment extends BaseFragment implements LoginView, View.OnClickListener {

    private LoginPresenter mPresenter;
    private EditText mAccount;
    private EditText mPassoword;
    private Button mLogin;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mAccount = (EditText) view.findViewById(R.id.et_phone_login);
        mPassoword = (EditText) view.findViewById(R.id.et_password_login);
        mLogin = (Button) view.findViewById(R.id.btn_login);
    }

    @Override
    protected int getLayoutId() {
        mPresenter = new LoginPresenter(mActivity);
        return R.layout.fragment_login;
    }

    @Override
    protected void setListener() {
        mLogin.setOnClickListener(this);
    }

    @Override
    public boolean checkAccount() {
        return RegexUtil.checkMobileNumber(mAccount.getText().toString());
    }

    @Override
    public boolean checkPassword() {
        return RegexUtil.checkPassword(mPassoword.getText().toString());
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loginComplete() {

    }


    @Override
    public void showMessage(String msg) {
        Toast.makeText(mActivity,msg , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                mPresenter.loginApp();
                break;
        }
    }
}
