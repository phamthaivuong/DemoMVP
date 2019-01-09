package com.example.phamthaivuong.demomvp.Register.Presenter;

import com.example.phamthaivuong.demomvp.Login.View.IloginView;
import com.example.phamthaivuong.demomvp.Register.Model.Register;
import com.example.phamthaivuong.demomvp.Register.View.IRegisterView;

public class RegisterPresenter implements IRegisterPresenter {
    IRegisterView iRegisterView;

    public RegisterPresenter(IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
    }

    @Override
    public void onLogin(String email, String password) {
        Register register = new Register(email, password);
        int registerCode = register.isValidData();

        if (registerCode ==0)
           iRegisterView.onRegisterError("You must enter your email");
        else if (registerCode ==1)
            iRegisterView.onRegisterError("You must enter valid email");
        else if (registerCode ==2)
            iRegisterView.onRegisterError("Password length must be greater than 6");
        else
            iRegisterView.onRegisterSuccess("Login Success");
    }
}
