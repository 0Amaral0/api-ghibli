package com.example.api_ghibli;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StudioGhibliAPI {

    @GET("films")
    Call<List<PostFilme>> getPosts();
}
