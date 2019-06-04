package com.codvision.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codvision.mvpdemo.login.LoginModelI;
import com.codvision.mvpdemo.login.LoginPresenter;
import com.codvision.mvpdemo.login.LoginPresenterI;
import com.codvision.mvpdemo.logout.LogoutModelI;
import com.codvision.mvpdemo.logout.LogoutPresenter;
import com.codvision.mvpdemo.logout.LogoutPresenterI;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText mUserName;
    private EditText mPassword;
    private Button mLogin;
    private Button mLogout;
    private ProgressBar mWaitLogin;

    private LoginPresenter loginPresenter;
    private LogoutPresenter logoutPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }


    private void initView() {
        mUserName = (EditText) findViewById(R.id.et_username);
        mPassword = (EditText) findViewById(R.id.et_password);
        mLogin = (Button) findViewById(R.id.btn_login);
        mLogout = (Button) findViewById(R.id.btn_logout);
        mWaitLogin = (ProgressBar) findViewById(R.id.pb_wait_login);
        loginPresenter = new LoginPresenterI(this, new LoginModelI());
        logoutPresenter = new LogoutPresenterI(this, new LogoutModelI());
    }

    private void initEvent() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUserName.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                //简单进行非空验证
                if (username != null && !username.equals("") && password != null && !password.equals("")) {
                    //这里想要执行登录操作，需要通过Present控制Model请求
                    loginPresenter.doLogin(username, password);
                } else {
                    Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }

            }
        });
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutPresenter.doLogout();
            }
        });
    }

    @Override
    public void showProgress() {
        mWaitLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mWaitLogin.setVisibility(View.GONE);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        //登录成功，跳转到主页面
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        //登录失败，停留在登录页面
    }

    @Override
    public void logoutSuccess() {
        Toast.makeText(this, "登出成功", Toast.LENGTH_SHORT).show();
        //登录成功，跳转到主页面
    }

    @Override
    public void logoutFail() {
        Toast.makeText(this, "登出失败", Toast.LENGTH_SHORT).show();
        //登录失败，停留在登录页面
    }
}
