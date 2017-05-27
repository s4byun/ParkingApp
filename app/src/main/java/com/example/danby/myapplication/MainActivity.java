package com.example.danby.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import com.example.danby.myapplication.util.AppUser;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.login.LoginManager;

import static com.example.danby.myapplication.R.id.button;


public class MainActivity extends FragmentActivity {
    final private int LOGIN_ACTIVITY_REQUEST_CODE = 0;

    private AccessToken accessToken;
    private AccessTokenTracker accessTokenTracker;

    private AppUser user;
    private Button logoutButton;
    private Button editProfileButton;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                accessToken = currentAccessToken;
            }
        };
        Log.d("accessTokenTracker", Boolean.toString(accessTokenTracker.isTracking()));
        accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, LOGIN_ACTIVITY_REQUEST_CODE);
        }
        else {
            setContentView(R.layout.activity_main);
            if(user == null)
                user = new AppUser();
            logoutButton = (Button) findViewById(R.id.logout_button);
            logoutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    accessToken = AccessToken.getCurrentAccessToken();
                    if(accessToken != null) {
                        LoginManager.getInstance().logOut();
                    }
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivityForResult(intent, LOGIN_ACTIVITY_REQUEST_CODE);
                }
            });
            editProfileButton = (Button) findViewById(R.id.edit_profile_button);
            editProfileButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    accessToken = AccessToken.getCurrentAccessToken();
                    if(accessToken != null) {
                        // bring up setup profile fragment
                       // public void onClick(View view) {

                        // Start NewActivity.class
                        Intent myIntent = new Intent(MainActivity.this, EditProfile.class);
                        startActivity(myIntent);
                    }

                }
            });

            // Capture button clicks



            user.getFbFriendList();
            displayFriends();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken != null) {
            if(user == null)
                user = new AppUser();
        }
        else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, LOGIN_ACTIVITY_REQUEST_CODE);
        }
    }

    private void displayFriends() {
        tv = (TextView) findViewById(R.id.tv);
        tv.setText(user.getFriendsStr());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LOGIN_ACTIVITY_REQUEST_CODE) {
            if(resultCode == AppConfig.FB_LOGIN_RETURN_CODE_SUCCESS) {
                Log.i("fb_login", "MainActivity received FB_LOGIN_RETURN_CODE_SUCCESS");
            }
            else if(resultCode == AppConfig.FB_LOGIN_RETURN_CODE_FAIL) {
                Log.e("fb_login", "MainActivity received FB_LOGIN_RETURN_CODE_FAIL");
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
    }


}
