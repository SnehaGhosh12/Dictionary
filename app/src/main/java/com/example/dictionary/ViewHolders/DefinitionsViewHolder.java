package com.example.dictionary.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;

public class DefinitionsViewHolder extends RecyclerView.ViewHolder {

    public TextView textview_Definition,textview_example,textview_Synonyms,textview_Antonyms;

    public DefinitionsViewHolder(@NonNull View itemView) {
        super(itemView);
        textview_Definition = itemView.findViewById(R.id.textview_Definition);
        textview_example = itemView.findViewById(R.id.textview_example);
//        textview_Synonyms = itemView.findViewById(R.id.textview_Synonyms);
//        textview_Antonyms = itemView.findViewById(R.id.textview_Antonyms);

    }
}
