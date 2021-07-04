package com.example.responsimobile.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsimobile.model.ContentItemDataHarian;
import com.example.responsimobile.model.ResponseDataHarian;
import com.example.responsimobile.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataHarianViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<ContentItemDataHarian>> listItemDataHarian = new MutableLiveData<>();

    public void setItemDataHarian(){
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }
        apiMain.getApiDataHarian().getResponseData().enqueue(new Callback<ResponseDataHarian>() {
            @Override
            public void onResponse(Call<ResponseDataHarian> call, Response<ResponseDataHarian> response) {
                ResponseDataHarian responseDataHarian = response.body();
                if(responseDataHarian != null && responseDataHarian.getDataHarian().getContent() != null){
                    ArrayList<ContentItemDataHarian> contentItemDataHarians = responseDataHarian.getDataHarian().getContent();
                    listItemDataHarian.postValue(contentItemDataHarians);
                }
            }

            @Override
            public void onFailure(Call<ResponseDataHarian> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<ContentItemDataHarian>> getResponseData(){
        return listItemDataHarian;
    }
}
