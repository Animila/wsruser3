package com.example.movieappws;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private Button register;
    private TextView login;
    private EditText email, password, first_name, last_name, password_confirmed;

    protected void setView() {
        register = (Button) findViewById(R.id.signUp_register);
        login = (TextView) findViewById(R.id.signUp_login);

        first_name = (EditText) findViewById(R.id.signUp_first_name);
        last_name = (EditText) findViewById(R.id.signUp_last_name);
        email = (EditText) findViewById(R.id.signUp_email);
        password = (EditText) findViewById(R.id.signUp_password);
        password_confirmed = (EditText) findViewById(R.id.signUp_password_confirm);
    }

    private void checkRegister() {
        register.setOnClickListener(viewLog -> {
            if (!(first_name.length() > 5 && last_name.length() > 5 && email.length() > 5 && password.length() > 5 && password_confirmed.length() > 5)) {
                Toast.makeText(this, "Заполните правильно все поля", Toast.LENGTH_SHORT).show();
            } else {
                if (!isEmailValid(email.getText().toString())) {
                    Toast.makeText(this, "Введите правильно почту", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.getText() != password_confirmed.getText()) {
                    Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                    return;
                }

            }


        });
    }

    public boolean isEmailValid(String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        setView();
        checkRegister();

        login.setOnClickListener(view -> {
            Intent signIn = new Intent(this, SignInActivity.class);
            startActivity(signIn);
            finish();
        });
    }
}