package com.example.api_ghibli;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StudioGhibliAPI {

    @GET("films")
    Call<List<PostFilme>> getPosts(@Query("id") String id);
}
