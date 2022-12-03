package com.example.movieappws;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_screen);
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                checkFirstStart();
            }
        };

        handler.postDelayed(r, 1000);

    }

    protected void nextSignIn() {
        Intent singIn = new Intent(this, SignInActivity.class);
        startActivity(singIn);
        finish();
    }
    protected void nextSignUp() {
        Intent singUp = new Intent(this, SignUpActivity.class);
        startActivity(singUp);
        finish();
    }

    private void checkFirstStart() {

        SharedPreferences sp = getSharedPreferences("hasVisited",
                Context.MODE_PRIVATE);
        // проверяем, первый ли раз открывается программа (Если вход первый то вернет false)
        boolean hasVisited = sp.getBoolean("hasVisited", false);

        if (!hasVisited) {
            // Сработает если Вход первый

            //Ставим метку что вход уже был
            SharedPreferences.Editor e = sp.edit();
            e.putBoolean("hasVisited", true);
            e.commit(); //После этого hasVisited будет уже true и будет означать, что вход уже был

            nextSignUp();

        }else {

            //Сработает если вход в приложение уже был
            //Ниже запускаем активность которая нужна при последующих входах
            nextSignIn();
        }
    }

}