package com.example.phamthaivuong.demomvp.Register.Model;

import android.text.TextUtils;
import android.util.Patterns;

public class Register implements IRegister{
    private String email,password;

    public Register(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPass() {
        return password;
    }

    @Override
    public int isValidData() {
        if (TextUtils.isEmpty(getEmail()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (getPass().length() <= 6)
            return 2;
        else
            return -1;
    }
}
