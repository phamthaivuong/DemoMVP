package com.example.phamthaivuong.demomvp.Register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.phamthaivuong.demomvp.R;
import com.example.phamthaivuong.demomvp.Register.Presenter.IRegisterPresenter;
import com.example.phamthaivuong.demomvp.Register.Presenter.RegisterPresenter;
import com.example.phamthaivuong.demomvp.Register.View.IRegisterView;

import es.dmoral.toasty.Toasty;

public class Register_Activity extends AppCompatActivity implements IRegisterView,View.OnClickListener {
    IRegisterPresenter iRegisterPresenter;
    EditText edt_email,edt_password;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);
        initView();
        addEvents();
    }

    private void addEvents() {
        btn_login.setOnClickListener(this);

    }

    private void initView() {
        edt_email = (EditText)findViewById(R.id.id_email);
        edt_password = (EditText)findViewById(R.id.id_password);
        btn_login = (Button)findViewById(R.id.id_login);
        iRegisterPresenter = new RegisterPresenter(this);

    }

    @Override
    public void onRegisterSuccess(String message) {
        Toasty.success(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRegisterError(String message) {
        Toasty.error(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        iRegisterPresenter.onLogin(edt_email.getText().toString(),edt_password.getText().toString());
    }
}
