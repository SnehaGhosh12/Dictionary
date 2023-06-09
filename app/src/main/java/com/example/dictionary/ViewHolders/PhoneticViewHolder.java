package com.example.dictionary.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {

    public TextView textview_phonetics;
    public ImageButton imagebtn_audio;

    public PhoneticViewHolder(@NonNull View itemView) {
        super(itemView);

        textview_phonetics = itemView.findViewById(R.id.textview_phonetics);
        imagebtn_audio = itemView.findViewById(R.id.imagebtn_audio);

    }
}
