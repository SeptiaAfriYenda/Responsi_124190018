package com.example.responsimobile.service;

import com.example.responsimobile.model.ResponseFaskes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RSRepository {
    @GET("sebaran_v2/jabar/faskes")
    Call<ResponseFaskes> getResponseRSRujukan();
}
