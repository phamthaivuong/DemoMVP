package com.example.phamthaivuong.demomvp.Login.Presenter;

import com.example.phamthaivuong.demomvp.Login.Model.User;
import com.example.phamthaivuong.demomvp.Login.View.IloginView;

public class LoginPresenter implements ILoginPresenter {

    IloginView loginView;

    public LoginPresenter(IloginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode  = user.isValidData();

        if (loginCode == 0)
            loginView.onLoginError("You must enter your email");
        else if (loginCode == 1)
            loginView.onLoginError("You must enter valid email");
        else if (loginCode == 2)
            loginView.onLoginError("Password length must be greater than 6");
        else
            loginView.onLoginSuccess("Login Success");
    }
}
