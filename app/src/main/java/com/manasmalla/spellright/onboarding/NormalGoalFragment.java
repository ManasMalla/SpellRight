package com.manasmalla.spellright.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manasmalla.spellright.R;

public class NormalGoalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_normal_goal, container, false);
        view.findViewById(R.id.constraintLayout6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleGoalFragment simpleGoalFragment = new SimpleGoalFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addSharedElement(view.findViewById(R.id.constraintLayout6), "simpleGoal").addSharedElement(view.findViewById(R.id.materialCardView2_normal), "goalCard")
                        .addSharedElement(view.findViewById(R.id.constraintLayout4_normal), "normalGoal").replace(R.id.goal_fragment, simpleGoalFragment).addToBackStack(null).commit();

                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.goal_fragment, normalGoalFragment).addToBackStack(null).commit();

            }
        });
        view.findViewById(R.id.constraintLayout5_normal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HardGoalFragment  hardGoalFragment = new HardGoalFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addSharedElement(view.findViewById(R.id.constraintLayout5_normal), "hardGoal").addSharedElement(view.findViewById(R.id.materialCardView2_normal), "goalCard")
                        .addSharedElement(view.findViewById(R.id.constraintLayout4_normal), "normalGoal").replace(R.id.goal_fragment, hardGoalFragment).addToBackStack(null).commit();

                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.goal_fragment, normalGoalFragment).addToBackStack(null).commit();

            }
        });
        view.findViewById(R.id.impressiveGoalCard_normal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImpressiveGoalFragment impressiveGoalFragment = new ImpressiveGoalFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addSharedElement(view.findViewById(R.id.impressiveGoalCard_normal), "ImpressiveGoal").addSharedElement(view.findViewById(R.id.materialCardView2_normal), "goalCard")
                        .addSharedElement(view.findViewById(R.id.constraintLayout4_normal), "normalGoal").replace(R.id.goal_fragment, impressiveGoalFragment).addToBackStack(null).commit();

                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.goal_fragment, normalGoalFragment).addToBackStack(null).commit();

            }
        });
        return view;
    }
}