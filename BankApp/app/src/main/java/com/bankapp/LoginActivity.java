package com.bankapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class LoginActivity extends AppCompatActivity {

    TextView etUsername;
    TextView etPassword;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();

        etUsername = (TextView)findViewById(R.id.et_username);
        etPassword = (TextView)findViewById(R.id.et_password);
        btLogin = (Button)findViewById(R.id.bt_login);
        btLogin.setOnClickListener(view -> logMe());
    }

    protected void logMe() {

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if(Encryption.checkCredentials(username, password)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}