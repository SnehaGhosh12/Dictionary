package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionary.Adapters.MeaningAdapter;
import com.example.dictionary.Adapters.PhoneticAdapters;
import com.example.dictionary.Models.API_Response;

public class MainActivity extends AppCompatActivity {

    SearchView search_view;
    TextView textview_Word;
    RecyclerView recycler_Phonetics,recycler_Meaning;
    ProgressDialog progressDialog;
    PhoneticAdapters phoneticAdapters;
    MeaningAdapter meaningAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view = findViewById(R.id.search_view);
        textview_Word = findViewById(R.id.textview_Word);
        recycler_Meaning = findViewById(R.id.recycler_Meaning);
        recycler_Phonetics = findViewById(R.id.recycler_Phonetics);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading..");
        progressDialog.show();
        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getWordMeaning(listener,"hello");

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching response for "+ query);
                progressDialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getWordMeaning(listener,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(API_Response apiResponse, String message) {
            progressDialog.dismiss();
            if(apiResponse == null){
                Toast.makeText(MainActivity.this, "No data found!", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiResponse);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();

        }
    };

    private void showData(API_Response apiResponse) {
        textview_Word.setText("Word: "+apiResponse.getWord());
        recycler_Phonetics.setHasFixedSize(true);
        recycler_Phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticAdapters = new PhoneticAdapters(this,apiResponse.getPhonetics());
        recycler_Phonetics.setAdapter(phoneticAdapters);
        recycler_Meaning.setHasFixedSize(true);
        recycler_Meaning.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter =new MeaningAdapter(this,apiResponse.getMeanings());
        recycler_Meaning.setAdapter(meaningAdapter);
    }
}