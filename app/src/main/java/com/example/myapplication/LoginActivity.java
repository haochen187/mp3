package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username,password;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn=findViewById(R.id.loginBtn);
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);
        loginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name="您好！"+username.getText()+"用户，欢迎参观";
        Intent i=new Intent().setClass(this,Localmp3Activity.class);
        Bundle bundle=new Bundle();
        bundle.putString("edit",name);
        i.putExtras(bundle);
        startActivity(i);

    }
}