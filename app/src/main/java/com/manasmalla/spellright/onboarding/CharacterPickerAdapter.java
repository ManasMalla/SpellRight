package com.manasmalla.spellright.onboarding;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.manasmalla.spellright.R;

import java.util.List;

public class CharacterPickerAdapter extends RecyclerView.Adapter<CharacterPickerAdapter.TextVH> {

    private Context context;
    private List<Integer> dataList;
    private RecyclerView recyclerView;

    public CharacterPickerAdapter(Context context, List<Integer> dataList, RecyclerView recyclerView) {
        this.context = context;
        this.dataList = dataList;
        this.recyclerView = recyclerView;
    }

    @Override
    public TextVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.character_picker_item_layout, parent, false);
        return new CharacterPickerAdapter.TextVH(view);
    }

    @Override
    public void onBindViewHolder(TextVH holder, final int position) {
        TextVH textVH = holder;
        textVH.character.setImageResource(dataList.get(position));
        textVH.character.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerView != null) {
                    recyclerView.smoothScrollToPosition(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void swapData(List<Integer> newData) {
        dataList = newData;
        notifyDataSetChanged();
    }

    class TextVH extends RecyclerView.ViewHolder {
        ImageView character;

        public TextVH(View itemView) {
            super(itemView);
            character = (ImageView) itemView.findViewById(R.id.characterCircleView);
        }
    }
}

