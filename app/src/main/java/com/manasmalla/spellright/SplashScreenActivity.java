package com.manasmalla.spellright;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar;
import com.akexorcist.roundcornerprogressbar.indeterminate.IndeterminateRoundCornerProgressBar;
import com.manasmalla.spellright.onboarding.OnBoardingActivity;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView startButton, loginButton;
    ConstraintLayout gettingStartedLayout;
    boolean isGettingStarted = false;
    IndeterminateRoundCornerProgressBar loadingBar;
    TextView loadingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_splash_screen);

        startButton = findViewById(R.id.startButton);
        loginButton = findViewById(R.id.loginButton);
        gettingStartedLayout = findViewById(R.id.gettingStartedLayout);
        loadingBar = findViewById(R.id.loadingProgressBar);
        loadingTextView = findViewById(R.id.loadingTextView);

        SpellRightUser.initialiseSharedPreferences(getApplicationContext());

        loadingBar.setOnProgressChangedListener(new BaseRoundCornerProgressBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(View view, float progress, boolean isPrimaryProgress, boolean isSecondaryProgress) {
                //Log.d("progress", String.valueOf(progress));
                if (progress >= 55) {
                    //Log.d("Hello", "40");
                    loadingTextView.setTextColor(ContextCompat.getColor(SplashScreenActivity.this, R.color.brownishOrange));
                } else if (progress == 0) {
                    loadingTextView.setTextColor(ContextCompat.getColor(SplashScreenActivity.this, R.color.white));
                }
            }
        });

        isGettingStarted = SpellRightUser.areUsersAvailable();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingTextView.setTextColor(ContextCompat.getColor(SplashScreenActivity.this, R.color.white));
                if (!isGettingStarted) {
                    loadingTextView.animate().alpha(0).setDuration(250);
                    loadingBar.animate().alpha(0).setDuration(250);
                    loadingBar.setVisibility(View.GONE);
                    gettingStartedLayout.setAlpha(0f);
                    gettingStartedLayout.setTranslationY(300);
                    gettingStartedLayout.setVisibility(View.VISIBLE);
                    gettingStartedLayout.animate().alpha(1f).translationYBy(-300).setDuration(500);

                    loginButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }
                    });

                    startButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SpellRightUser.setGuestUser(true);
                            Intent intent = new Intent(getApplicationContext(), OnBoardingActivity.class);
                            startActivity(intent);
                        }
                    });

                } else {
                    if (SpellRightUser.isCurrentUsernameAvailable() || (SpellRightUser.isGuestUser() && !SpellRightUser.isCurrentUsernameAvailable())){
                        Toast.makeText(getApplicationContext(), "Welcome back, " + SpellRightUser.getUsername() + "! 👋", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                        startActivity(intent);
                    }else{
                        //NO CURRENT USER
                        if (SpellRightUser.getNumberOfUsers() > 1 || (SpellRightUser.getNumberOfUsers() == 1 && SpellRightUser.isGuestUser())){
                            //DISPLAY USERS LIST
                        }
                    }
                }
            }
        }, 4000);

    }
}