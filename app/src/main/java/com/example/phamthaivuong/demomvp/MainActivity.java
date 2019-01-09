package com.example.phamthaivuong.demomvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.phamthaivuong.demomvp.Login.Presenter.ILoginPresenter;
import com.example.phamthaivuong.demomvp.Login.Presenter.LoginPresenter;
import com.example.phamthaivuong.demomvp.Login.View.IloginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements IloginView, View.OnClickListener {
    EditText edt_email,edt_password;
    Button btnLogin;
    ILoginPresenter iLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addEvents();
    }

    private void addEvents() {
        btnLogin.setOnClickListener(this);
    }

    private void initView() {
        btnLogin = (Button)findViewById(R.id.id_login);
        edt_email = (EditText)findViewById(R.id.id_email);
        edt_password = (EditText)findViewById(R.id.id_password);
        iLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        iLoginPresenter.onLogin(edt_email.getText().toString(),edt_password.getText().toString());
    }
}
