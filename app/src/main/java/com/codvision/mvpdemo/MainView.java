package com.codvision.mvpdemo;

/**
 * Created by sxy on 2019/5/7 20:10
 * todo
 */
public interface MainView {
    void showProgress();
    void hideProgress();
    void loginSuccess();
    void loginFail();
    void logoutSuccess();
    void logoutFail();
}

