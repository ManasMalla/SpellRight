package com.manasmalla.spellright;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

public class StudyActivity extends AppCompatActivity {

    Pair<View, String>[] pairs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_study);
        pairs = new Pair[5];
        pairs[0] = new Pair<View, String>(findViewById(R.id.studyIndicator_studyActivity), "studyIndicator");
        pairs[1] = new Pair<View, String>(findViewById(R.id.bookIndicator_studyActivity), "bookIndicator");
        pairs[2] = new Pair<View, String>(findViewById(R.id.gameIndicator_studyActivity), "gameIndicator");
        pairs[3] = new Pair<View, String>(findViewById(R.id.aToZIndicator_studyActivity), "aToZIndicator");
        pairs[4] = new Pair<View, String>(findViewById(R.id.userIndicator_studyActivity), "userIndicator");
    }

    public void goToUserActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        ActivityOptions activityOptionsCompat = ActivityOptions.makeSceneTransitionAnimation(StudyActivity.this, pairs);
        startActivity(intent, activityOptionsCompat.toBundle());
    }

}