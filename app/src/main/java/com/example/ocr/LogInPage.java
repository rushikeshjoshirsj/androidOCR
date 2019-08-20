package com.example.ocr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LogInPage extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private Button loginButton;
    private TextView validate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);
        username = (TextView)findViewById(R.id.userName);
        password = (TextView)findViewById(R.id.passWord);
        loginButton = (Button)findViewById(R.id.login);
        validate = (TextView)findViewById(R.id.validate);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateLogin(username.getText().toString(),password.getText().toString());
            }
        });
    }

    private void validateLogin(String userName, String password) {
        if(userName.equalsIgnoreCase("Advisor") && password.equals("advisor")) {
            startActivity(new Intent(getApplicationContext(), StartNewCase.class));
        } else {
            validate.setText("*Invalid UserName or Password");
        }
    }
}
