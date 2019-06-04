package com.codvision.mvpdemo.login;

import com.codvision.mvpdemo.MainView;

/**
 * Created by sxy on 2019/5/7 20:11
 * todo
 */
public class LoginPresenterI implements LoginPresenter, LoginModel.OnLoginListener {
    private MainView mView;
    private LoginModel mModel;

    public LoginPresenterI(MainView mView, LoginModel mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }

    @Override
    public void doLogin(String username, String password) {
        mView.showProgress();
        mModel.login(username, password, this);
    }

    @Override
    public void onLoginSuccess() {
        mView.hideProgress();
        mView.loginSuccess();
    }

    @Override
    public void onLoginFail() {
        mView.hideProgress();
        mView.loginFail();
    }
}
