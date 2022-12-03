package com.example.movieappws;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn_screen extends AppCompatActivity {

    private Button login;
    private TextView register;
    private EditText email, password;

    private void setView() {
        login = (Button) findViewById(R.id.signIn_login);
        register = (TextView) findViewById(R.id.signIn_register);
        email = (EditText) findViewById(R.id.signIn_email);
        password = (EditText) findViewById(R.id.signIn_password);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);

        setView();
        authCheck();
        setSignUp();



    }

    private void setSignUp() {
        register.setOnClickListener(viewReg -> {
            Intent signUp = new Intent(this, SignUp_screen.class);
            startActivity(signUp);
            finish();
        });
    }

    private void authCheck() {
        login.setOnClickListener(viewLog -> {
            if (!(email.length() > 5 && password.length() > 5)) {
                Toast.makeText(this, "Введите логин или пароль", Toast.LENGTH_SHORT).show();
                return;
            }

            authSend();
        });
    }

    private void authSend() {
        String emailData = email.getText().toString();
        String passwordData = password.getText().toString();


    }

}