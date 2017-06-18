package com.example.danby.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class LoginActivity extends FragmentActivity {
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i("fb_login", "Login success: " + loginResult.toString());
                loginButton.setVisibility(View.GONE);
                setResult(AppConfig.FB_LOGIN_RETURN_CODE_SUCCESS);
                startActivity(new Intent(LoginActivity.this, MapsActivity.class));
                finish();
            }

            @Override
            public void onCancel() {
                Log.i("fb_login", "Login cancelled");
            }

            @Override
            public void onError(FacebookException e) {
                Log.e("fb_login", e.toString());
                setResult(AppConfig.FB_LOGIN_RETURN_CODE_FAIL);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
