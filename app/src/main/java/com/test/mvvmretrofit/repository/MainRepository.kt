package com.test.mvvmretrofit.repository

import com.test.mvvmretrofit.Movie
import com.test.mvvmretrofit.di.ApiService
import retrofit2.Response

interface MainRepository {

   suspend fun getAllMovies() : Response<List<Movie>>
}