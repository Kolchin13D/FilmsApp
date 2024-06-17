package com.example.filmsapp.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.filmsapp.R;
import com.example.filmsapp.service.MovieDataService;
import com.example.filmsapp.service.RetrofitInstance;

import java.lang.annotation.Retention;
import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieRepository {

    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData(){

        MovieDataService movieDataService = RetrofitInstance.getService();

        Call<Result> call = movieDataService.getPopularMoview(application
                .getApplicationContext().getString(R.string.api_key));

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();

                if(result != null && result.getResults() != null){

                    movies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movies);

                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {

            }
        });

        return mutableLiveData;
    }
}
