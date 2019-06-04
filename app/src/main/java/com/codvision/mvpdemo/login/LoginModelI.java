package com.codvision.mvpdemo.login;

import android.os.Handler;

/**
 * Created by sxy on 2019/5/7 20:10
 * todo
 */
public class LoginModelI implements LoginModel{

    @Override
    public void login(final String username, final String password, final OnLoginListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (username.equals("1") && password.equals("1")) {
                    listener.onLoginSuccess();
                } else {
                    listener.onLoginFail();
                }
            }
        }, 3000);
    }
}
