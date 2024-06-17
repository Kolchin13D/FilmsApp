package com.example.filmsapp.service;

import com.example.filmsapp.model.Movie;
import com.example.filmsapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {

    // base url
    //https://api.themoviedb.org/3/movie/11?api_key=7d79837ede02bcd669b029c88990cf1c

    @GET("movie/popular")
    Call<Result> getPopularMoview(@Query("api") String apiKey);




}
