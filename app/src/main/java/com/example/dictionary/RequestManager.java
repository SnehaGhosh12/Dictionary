package com.example.dictionary;

import android.content.Context;
import android.widget.Toast;

import com.example.dictionary.Models.API_Response;
import com.example.dictionary.Models.Meanings;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public class RequestManager {
    Context context;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getWordMeaning(OnFetchDataListener listener, String word){
        CallDictionary callDictionary = retrofit.create(CallDictionary.class);
        Call<List<API_Response>> call = callDictionary.callMeanings(word);

        try{
            call.enqueue(new Callback<List<API_Response>>() {
                @Override
                public void onResponse(Call<List<API_Response>> call, Response<List<API_Response>> response) {
                    if (!response.isSuccessful()){
                        Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listener.onFetchData(response.body().get(0), response.message());
                }

                @Override
                public void onFailure(Call<List<API_Response>> call, Throwable t) {
                    listener.onError("Request Failed!");

                }
            });
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "An Error Occurred!", Toast.LENGTH_SHORT).show();
        }
    }

    public interface CallDictionary {
        @GET("entries/en/{word}")
        Call<List<API_Response>> callMeanings(
            @Path("word") String word
        );
    }
}
