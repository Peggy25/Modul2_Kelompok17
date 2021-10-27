package com.example.modul2_kelompok17.data;

import com.example.modul2_kelompok17.Model.response.ListUserResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("api/users?page=2")
    Call<ListUserResponse> getList();
}
