package com.codvision.mvpdemo.logout;

import com.codvision.mvpdemo.MainView;

/**
 * Created by sxy on 2019/5/7 20:23
 * todo
 */
public class LogoutPresenterI implements LogoutPresenter, LogoutModel.onLogoutListener {
    private MainView mainView;
    private LogoutModel logoutModel;

    public LogoutPresenterI(MainView mainView, LogoutModel logoutModel) {
        this.mainView = mainView;
        this.logoutModel = logoutModel;
    }

    @Override
    public void onLogoutSuccess() {
        mainView.hideProgress();
        mainView.logoutSuccess();
    }

    @Override
    public void onLogoutFail() {
        mainView.hideProgress();
        mainView.logoutFail();
    }

    @Override
    public void doLogout() {
        logoutModel.logout(this);
        mainView.showProgress();
    }
}
