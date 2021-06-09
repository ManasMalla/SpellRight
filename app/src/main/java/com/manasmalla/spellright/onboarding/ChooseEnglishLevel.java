package com.manasmalla.spellright.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.manasmalla.spellright.R;
import com.manasmalla.spellright.SpellRightUser;
import com.manasmalla.spellright.enums.DifficultyLevel;
import com.manasmalla.spellright.enums.Goal;

import java.util.ArrayList;
import java.util.List;

public class ChooseEnglishLevel extends Fragment {

    ViewPager2 levelViewPager;
    TextView[] dots;
    LinearLayout dotsLayout;
    List<Fragment> levels;
    DifficultyLevel difficultyLevel = DifficultyLevel.BEGINNER;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choose_english_level, container, false);

        levels = new ArrayList<>();
        levels.add(new BeginnerFragment());
        levels.add(new IntermediateFragment());
        levels.add(new ChallengingFragment());
        levels.add(new ExpertFragment());

        view.findViewById(R.id.nextButton_slideThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellRightUser.setDifficultyLevel(difficultyLevel);
                OnBoardingActivity onBoardingActivity = (OnBoardingActivity) getActivity();
                onBoardingActivity.viewPager.setCurrentItem(3, true);
            }
        });
        view.findViewById(R.id.backButton_slideThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBoardingActivity onBoardingActivity = (OnBoardingActivity) getActivity();
                onBoardingActivity.viewPager.setCurrentItem(1, true);
            }
        });
        view.findViewById(R.id.chevron_left_slide3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBoardingActivity onBoardingActivity = (OnBoardingActivity) getActivity();
                onBoardingActivity.viewPager.setCurrentItem(1, true);
            }
        });
        levelViewPager = view.findViewById(R.id.viewPager_englishLevel);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(levels, getActivity().getSupportFragmentManager(), getLifecycle());
        levelViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                difficultyLevel = setLevelFromPosition(position);
                ImageView[] indicators = new ImageView[]{view.findViewById(R.id.indicatorLevelOne), view.findViewById(R.id.indicatorLevelTwo),
                        view.findViewById(R.id.indicatorLevelThree), view.findViewById(R.id.indicatorLevelFour)};
                int[] drawables = new int[]{R.drawable.button_background_blue, R.color.indicatorInactive};
                for (int i = 0; i < indicators.length; i++) {
                    Log.d("Position", String.valueOf(position));
                    if (i == position) {
                        ViewGroup.LayoutParams layoutParams = indicators[i].getLayoutParams();
                        layoutParams.width = getResources().getDimensionPixelSize(R.dimen.twentyDP);
                        layoutParams.height = getResources().getDimensionPixelSize(R.dimen.twentyDP);
                        indicators[i].setLayoutParams(layoutParams);
                        indicators[i].setBackgroundResource(drawables[0]);
                    } else {
                        ViewGroup.LayoutParams layoutParams = indicators[i].getLayoutParams();
                        layoutParams.width = getResources().getDimensionPixelSize(R.dimen.fourteenDP);
                        layoutParams.height = getResources().getDimensionPixelSize(R.dimen.fourteenDP);
                        indicators[i].setLayoutParams(layoutParams);
                        indicators[i].setBackgroundColor(getResources().getColor(R.color.indicatorInactive));
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        levelViewPager.setAdapter(viewPagerAdapter);
        return view;
    }

    public DifficultyLevel setLevelFromPosition(int position){
        DifficultyLevel returnedLevel = DifficultyLevel.BEGINNER;
        switch (position){
            case 0:
                returnedLevel =  DifficultyLevel.BEGINNER;
            case 1:
                returnedLevel =   DifficultyLevel.INTERMEDIATE;
            case 2:
                returnedLevel =   DifficultyLevel.CHALLENGING;
            case 3:
                returnedLevel =   DifficultyLevel.EXPERT;
        }
        return returnedLevel;
    }

}