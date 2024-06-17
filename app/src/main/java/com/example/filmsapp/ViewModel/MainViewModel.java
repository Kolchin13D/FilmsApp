package com.example.filmsapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.filmsapp.model.Movie;
import com.example.filmsapp.model.MovieRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    public MainViewModel(@NonNull Application application, MovieRepository movieRepository) {
        super(application);
        movieRepository = new MovieRepository(application);
    }

    // live date
    public LiveData<List<Movie>> getAllMovies(){
        return movieRepository.getMutableLiveData();
    }



}
