package com.manasmalla.spellright.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manasmalla.spellright.R;

public class HardGoalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hard_goal, container, false);
        view.findViewById(R.id.constraintLayout6_hard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleGoalFragment simpleGoalFragment = new SimpleGoalFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addSharedElement(view.findViewById(R.id.constraintLayout6_hard), "simpleGoal").addSharedElement(view.findViewById(R.id.materialCardView2_hard), "goalCard")
                        .addSharedElement(view.findViewById(R.id.constraintLayout5_hard), "hardGoal").replace(R.id.goal_fragment, simpleGoalFragment).addToBackStack(null).commit();

                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.goal_fragment, normalGoalFragment).addToBackStack(null).commit();

            }
        });
        view.findViewById(R.id.impressiveGoalCard_hard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImpressiveGoalFragment impressiveGoalFragment = new ImpressiveGoalFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addSharedElement(view.findViewById(R.id.constraintLayout5_hard), "hardGoal").addSharedElement(view.findViewById(R.id.materialCardView2_hard), "goalCard")
                        .addSharedElement(view.findViewById(R.id.impressiveGoalCard_hard), "ImpressiveGoal").replace(R.id.goal_fragment, impressiveGoalFragment).addToBackStack(null).commit();

                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.goal_fragment, normalGoalFragment).addToBackStack(null).commit();

            }
        });
        view.findViewById(R.id.constraintLayout4_hard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NormalGoalFragment normalGoalFragment = new NormalGoalFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addSharedElement(view.findViewById(R.id.constraintLayout5_hard), "hardGoal").addSharedElement(view.findViewById(R.id.materialCardView2_hard), "goalCard")
                        .addSharedElement(view.findViewById(R.id.constraintLayout4_hard), "normalGoal").replace(R.id.goal_fragment, normalGoalFragment).addToBackStack(null).commit();

                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.goal_fragment, normalGoalFragment).addToBackStack(null).commit();

            }
        });
        return view;
    }
}