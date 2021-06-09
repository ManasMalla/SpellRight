package com.manasmalla.spellright.onboarding;

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

import com.manasmalla.spellright.R;

import java.util.ArrayList;
import java.util.List;

import travel.ithaka.android.horizontalpickerlib.PickerLayoutManager;

public class ChooseCharacterFragment extends Fragment {

    RecyclerView languageRv;
    CharacterPickerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_choose_character, container, false);
        view.findViewById(R.id.nextButton_slide1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBoardingActivity onBoardingActivity = (OnBoardingActivity) getActivity();
                onBoardingActivity.viewPager.setCurrentItem(1, true);
            }
        });

        languageRv = view.findViewById(R.id.characterRecyclerView);

        PickerLayoutManager pickerLayoutManager = new PickerLayoutManager(getActivity(), PickerLayoutManager.HORIZONTAL, false);
        pickerLayoutManager.setChangeAlpha(true);
        pickerLayoutManager.setChangeAlpha(false);
        pickerLayoutManager.setScaleDownBy(0.4f);

        List<Integer>  characters = new ArrayList<>();
        characters.add(R.drawable.characters);
        characters.add(R.drawable.fox);
        characters.add(R.drawable.expert);

        adapter = new CharacterPickerAdapter(getActivity(), characters, languageRv);
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
                        holder.itemView.findViewById(R.id.tickView_itemCharacter).setAlpha(0f);
                    }
                }
                textView.findViewById(R.id.tickView_itemCharacter).setAlpha(1f);
            }
        });

        return view;
    }
}