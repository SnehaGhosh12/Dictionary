package com.example.dictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.Models.Definitions;
import com.example.dictionary.R;
import com.example.dictionary.ViewHolders.DefinitionsViewHolder;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionsViewHolder> {

    private Context context;
    private List<Definitions> definitionsList;

    public DefinitionAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionsViewHolder(LayoutInflater.from(context).inflate(R.layout.definitions_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionsViewHolder holder, int position) {
        holder.textview_Definition.setText("Definition: "+definitionsList.get(position).getDefinition());
        holder.textview_example.setText("Example: "+definitionsList.get(position).getExample());
//        StringBuilder synonyms = new StringBuilder();
//        StringBuilder antonyms = new StringBuilder();
//
//        synonyms.append(definitionsList.get(position).getSynonyms());
//        antonyms.append(definitionsList.get(position).getAntonyms());
//
//        holder.textview_Synonyms.setText(synonyms);
//        holder.textview_Antonyms.setText(antonyms);
//
//        holder.textview_Synonyms.setSelected(true);
//        holder.textview_Antonyms.setSelected(true);

    }

    @Override
    public int getItemCount() {

        return definitionsList.size();
    }
}
