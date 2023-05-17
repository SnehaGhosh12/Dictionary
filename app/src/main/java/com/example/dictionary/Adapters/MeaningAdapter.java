package com.example.dictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.Models.Meanings;
import com.example.dictionary.R;
import com.example.dictionary.ViewHolders.MeaningViewHolder;

import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningViewHolder>{

    private Context context;

    public MeaningAdapter(Context context, List<Meanings> meanings) {
        this.context = context;
        this.meaningsList = meanings;
    }

    protected List<Meanings> meaningsList;

    @NonNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {
        holder.textview_partsOfSpeech.setText("Parts of Speech: "+ meaningsList.get(position).getPartOfSpeech());
        holder.recycler_definitions.setHasFixedSize(true);
        holder.recycler_definitions.setLayoutManager(new GridLayoutManager(context,1));
        DefinitionAdapter definitionAdapter = new DefinitionAdapter(context,meaningsList.get(position).getDefinitions());
        holder.recycler_definitions.setAdapter(definitionAdapter);


    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
