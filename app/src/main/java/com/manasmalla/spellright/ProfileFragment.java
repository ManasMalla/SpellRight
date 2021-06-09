package com.manasmalla.spellright;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manasmalla.spellright.utils.CircularProgressBar;

public class ProfileFragment extends Fragment {

    CircularProgressBar circularProgressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        circularProgressBar = view.findViewById(R.id.circularProgressBar);
        circularProgressBar.setProgress(50);

        return view;
    }
}