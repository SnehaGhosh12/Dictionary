package com.example.dictionary;

import com.example.dictionary.Models.API_Response;

public interface OnFetchDataListener {

    void onFetchData(API_Response apiResponse, String message);
    void onError(String message);
}
