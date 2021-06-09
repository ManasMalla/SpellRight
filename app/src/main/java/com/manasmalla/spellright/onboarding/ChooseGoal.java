package com.manasmalla.spellright.onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.manasmalla.spellright.DashboardActivity;
import com.manasmalla.spellright.R;
import com.manasmalla.spellright.SpellRightUser;
import com.manasmalla.spellright.enums.Goal;

public class ChooseGoal extends Fragment {

    public FragmentContainerView fragmentContainerView;
    ImageView goalHelper;
    Goal goal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choose_goal, container, false);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.goal_fragment, new SimpleGoalFragment()).addToBackStack(null).commit();

        goalHelper = view.findViewById(R.id.imageView3);
        goalHelper.setRotation(0);
        goalHelper.setTranslationX(-1000);
        goalHelper.animate().rotationBy(0).translationXBy(1000).alpha(1).setDuration(750);


        view.findViewById(R.id.completeButton_slideFour).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.findViewById(R.id.goal_fragment).findViewById(R.id.impressiveCard_impressive) != null) {
                    goal = Goal.IMPRESSIVE;
                } else if (view.findViewById(R.id.goal_fragment).findViewById(R.id.impressiveGoalCard_hard) != null) {
                    goal = Goal.HARD;
                } else if (view.findViewById(R.id.goal_fragment).findViewById(R.id.simpleGoalCL) != null) {
                    goal = Goal.SIMPLE;
                } else if (view.findViewById(R.id.goal_fragment).findViewById(R.id.impressiveGoalCard_normal) != null) {
                    goal = Goal.NORMAL;
                }
                SpellRightUser.setGoal(goal, new SpellRightUser.OnSuccessListener() {
                    @Override
                    public void onSuccess() {
                        Intent intent = new Intent(getActivity().getApplicationContext(), DashboardActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        view.findViewById(R.id.backButton_slideFour).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBoardingActivity onBoardingActivity = (OnBoardingActivity) getActivity();
                onBoardingActivity.viewPager.setCurrentItem(2, true);
            }
        });
        view.findViewById(R.id.chevron_left_slide4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBoardingActivity onBoardingActivity = (OnBoardingActivity) getActivity();
                onBoardingActivity.viewPager.setCurrentItem(2, true);
            }
        });

        return view;
    }
}