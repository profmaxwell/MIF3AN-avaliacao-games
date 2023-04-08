package com.mobile.pacifier.services;

import com.mobile.pacifier.model.Troca;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TrocaServiceImpl {

    @GET("trocas")
    Call<List<Troca>> getTrocas();

}
