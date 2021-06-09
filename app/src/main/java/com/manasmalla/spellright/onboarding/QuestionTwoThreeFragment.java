package com.manasmalla.spellright.onboarding;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.manasmalla.spellright.R;

import java.util.ArrayList;
import java.util.List;

import travel.ithaka.android.horizontalpickerlib.PickerLayoutManager;

public class QuestionTwoThreeFragment extends Fragment {

    RecyclerView languageRv;
    PickerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_two_three, container, false);
        view.findViewById(R.id.nextButton_slideTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBoardingActivity onBoardingActivity = (OnBoardingActivity) getActivity();
                onBoardingActivity.viewPager.setCurrentItem(2, true);
            }
        });
        view.findViewById(R.id.backButton_slideTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBoardingActivity onBoardingActivity = (OnBoardingActivity) getActivity();
                onBoardingActivity.viewPager.setCurrentItem(0, true);
            }
        });
        view.findViewById(R.id.chevron_left_slide2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBoardingActivity onBoardingActivity = (OnBoardingActivity) getActivity();
                onBoardingActivity.viewPager.setCurrentItem(0, true);
            }
        });

        languageRv = view.findViewById(R.id.nativeLanguageRecyclerView);

        PickerLayoutManager pickerLayoutManager = new PickerLayoutManager(getActivity(), PickerLayoutManager.HORIZONTAL, false);
        pickerLayoutManager.setChangeAlpha(true);
        pickerLayoutManager.setChangeAlpha(false);
        pickerLayoutManager.setScaleDownBy(0.45f);

        List<String> languages = new ArrayList<>();
        languages.add("Telugu");
        languages.add("Hindi");
        languages.add("Sanskrit");

        adapter = new PickerAdapter(getActivity(), languages, languageRv);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(languageRv);
        languageRv.setLayoutManager(pickerLayoutManager);
        languageRv.setAdapter(adapter);

        pickerLayoutManager.setOnScrollStopListener(new PickerLayoutManager.onScrollStopListener() {
            @Override
            public void selectedView(View textView) {
                for (int i = 0; i <= 2; i++) {
                    RecyclerView.ViewHolder holder = languageRv.findViewHolderForAdapterPosition(i);
                    if (holder != null){
                        holder.itemView.findViewById(R.id.tickView_itemLanguage).setAlpha(0f);
                    }
                }
                TextView textView1 = textView.findViewById(R.id.picker_item);
                textView.findViewById(R.id.tickView_itemLanguage).setAlpha(1f);
                Log.d("Language", textView1.getText().toString());
            }
        });

        return view;
    }
}