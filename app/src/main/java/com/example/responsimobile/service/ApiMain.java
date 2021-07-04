package com.example.responsimobile.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;

    public CovidRepository getApiDataHarian(){
        String base_url = "https://covid19-public.digitalservice.id/api/v1/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CovidRepository.class);
    }

    public RSRepository getApiRSRujukan(){
        String base_url = "https://covid19-public.digitalservice.id/api/v1/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RSRepository.class);
    }
}
