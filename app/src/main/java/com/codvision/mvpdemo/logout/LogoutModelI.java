package com.codvision.mvpdemo.logout;

import android.os.Handler;

/**
 * Created by sxy on 2019/5/7 20:27
 * todo
 */
public class LogoutModelI implements LogoutModel {


    @Override
    public void logout(final onLogoutListener logoutListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logoutListener.onLogoutSuccess();
            }
        }, 3000);
    }
}
