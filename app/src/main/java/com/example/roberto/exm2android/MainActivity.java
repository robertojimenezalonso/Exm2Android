package com.example.roberto.exm2android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;




public class MainActivity extends AppCompatActivity {

    CallbackManager callbackManager;
     LoginButton loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
