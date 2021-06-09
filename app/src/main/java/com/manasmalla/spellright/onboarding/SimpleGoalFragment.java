package com.manasmalla.spellright.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.manasmalla.spellright.R;

public class SimpleGoalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_goal, container, false);
        view.findViewById(R.id.constraintLayout4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NormalGoalFragment normalGoalFragment = new NormalGoalFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addSharedElement(view.findViewById(R.id.simpleGoalCL), "simpleGoal").addSharedElement(view.findViewById(R.id.materialCardView2), "goalCard")
                        .addSharedElement(view.findViewById(R.id.constraintLayout4), "normalGoal").replace(R.id.goal_fragment, normalGoalFragment).addToBackStack(null).commit();

                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.goal_fragment, normalGoalFragment).addToBackStack(null).commit();

            }
        });
        view.findViewById(R.id.constraintLayout5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HardGoalFragment hardGoalFragment = new HardGoalFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addSharedElement(view.findViewById(R.id.constraintLayout5), "hardGoal").addSharedElement(view.findViewById(R.id.materialCardView2), "goalCard")
                        .addSharedElement(view.findViewById(R.id.simpleGoalCL), "simpleGoal").replace(R.id.goal_fragment, hardGoalFragment).addToBackStack(null).commit();

                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.goal_fragment, normalGoalFragment).addToBackStack(null).commit();

            }
        });
        view.findViewById(R.id.impressiveGoalCard_simple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImpressiveGoalFragment impressiveGoalFragment = new ImpressiveGoalFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addSharedElement(view.findViewById(R.id.impressiveGoalCard_simple), "ImpressiveGoal").addSharedElement(view.findViewById(R.id.materialCardView2), "goalCard")
                        .addSharedElement(view.findViewById(R.id.simpleGoalCL), "simpleGoal").replace(R.id.goal_fragment, impressiveGoalFragment).addToBackStack(null).commit();

                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.goal_fragment, normalGoalFragment).addToBackStack(null).commit();

            }
        });
        return view;
    }
}