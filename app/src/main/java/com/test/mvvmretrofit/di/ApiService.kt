package com.test.mvvmretrofit.di

import com.test.mvvmretrofit.Movie
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("movielist.json")
    fun getAllMovies() : Response<List<Movie>>
}