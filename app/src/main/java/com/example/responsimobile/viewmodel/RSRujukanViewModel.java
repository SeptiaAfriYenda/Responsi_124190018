package com.example.responsimobile.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsimobile.model.DataItemFaskes;

import com.example.responsimobile.model.ResponseFaskes;
import com.example.responsimobile.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RSRujukanViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<DataItemFaskes>> listItemFaskes = new MutableLiveData<>();

    public void setItemFaskes() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }
        apiMain.getApiRSRujukan().getResponseRSRujukan().enqueue(new Callback<ResponseFaskes>() {

            @Override
            public void onResponse(Call<ResponseFaskes> call, Response<ResponseFaskes> response) {
                ResponseFaskes responseFaskes = response.body();
                if(responseFaskes != null && responseFaskes.getData() != null){
                    ArrayList<DataItemFaskes> dataItemFaskes = responseFaskes.getData();
                    listItemFaskes.postValue(dataItemFaskes);
                }
            }


            @Override
            public void onFailure(Call<ResponseFaskes> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<DataItemFaskes>> getResponseRSRujukan(){
        return listItemFaskes;
    }
}
