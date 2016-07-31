package com.example.petrpan.whazzup;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private TextView logo;

    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);
        logo=(TextView) findViewById(R.id.logo);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Lobster 1.4.otf");
        logo.setTypeface(custom_font);
        Animation anim= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.accelerate_decelerate);
        logo.startAnimation(anim);
        info = (TextView)findViewById(R.id.info);
        if (isLoggedIn())
        {
            Intent data=new Intent(MainActivity.this, mainMenuActivity.class);
            MainActivity.this.startActivity(data);
            info.setText("");
        }
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.startAnimation(anim);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent data=new Intent(MainActivity.this, mainMenuActivity.class);
                MainActivity.this.startActivity(data);
                info.setText("");
            }
            @Override
            public void onCancel() {
                info.setText("Try again!!");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Try again!!");
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }
}
