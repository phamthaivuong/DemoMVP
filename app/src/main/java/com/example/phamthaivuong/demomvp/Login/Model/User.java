package com.example.phamthaivuong.demomvp.Login.Model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser {

    private String email,password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        // 0. check email is empty // kiểm tra email trống
        // 1. check email is matches pattern // kiểm tra email là mẫu phù hợp
        // 2. check password length >6 // kiểm tra độ dài mật khẩu> 6

        if (TextUtils.isEmpty(getEmail()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (getPassword().length() <= 6)
            return 2;
        else
            return -1;

    }
}
