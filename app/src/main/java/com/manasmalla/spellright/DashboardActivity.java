package com.manasmalla.spellright;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    Pair<View, String>[] pairs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_dashboard);
        pairs = new Pair[5];
        pairs[0] = new Pair<View, String>(findViewById(R.id.studyIndicator_dashboardActivity), "studyIndicator");
        pairs[1] = new Pair<View, String>(findViewById(R.id.bookIndicator_dashboardActivity), "bookIndicator");
        pairs[2] = new Pair<View, String>(findViewById(R.id.gameIndicator_dashboardActivity), "gameIndicator");
        pairs[3] = new Pair<View, String>(findViewById(R.id.aToZIndicator_dashboardActivity), "aToZIndicator");
        pairs[4] = new Pair<View, String>(findViewById(R.id.userIndicator_dashboardActivity), "userIndicator");
//        CircularProgressBar circularProgressBar = findViewById(R.id.circularProgressBar);
//        circularProgressBar.setProgress(60);
    }

    public void goToStudyActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), StudyActivity.class);
        ActivityOptions activityOptionsCompat = ActivityOptions.makeSceneTransitionAnimation(DashboardActivity.this, pairs);
        startActivity(intent, activityOptionsCompat.toBundle());
    }
}