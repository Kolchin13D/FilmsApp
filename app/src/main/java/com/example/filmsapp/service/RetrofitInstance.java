package com.example.filmsapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.themoviedb.org/3/movie/11?api_key=7d79837ede02bcd669b029c88990cf1c";

    public static MovieDataService getService(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(MovieDataService.class);
    }

}
