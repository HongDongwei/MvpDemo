package com.codvision.mvpdemo.login;

/**
 * Created by sxy on 2019/5/7 20:10
 * todo
 */
public interface LoginModel {
    interface OnLoginListener {
        void onLoginSuccess();
        void onLoginFail();
    }

    void login(String username, String password, OnLoginListener listener);
}
