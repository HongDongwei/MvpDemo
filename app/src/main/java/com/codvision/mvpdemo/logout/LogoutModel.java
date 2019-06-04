package com.codvision.mvpdemo.logout;

/**
 * Created by sxy on 2019/5/7 20:25
 * todo
 */
public interface LogoutModel {
    interface onLogoutListener {
        void onLogoutSuccess();

        void onLogoutFail();
    }

    void logout(onLogoutListener logoutListener);
}
