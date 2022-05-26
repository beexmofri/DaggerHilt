package com.test.mvvmretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.mvvmretrofit.Movie
import com.test.mvvmretrofit.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {

        errorMessage.value = true.toString()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getAllMovies()
            if (response.isSuccessful) {
                movieList.postValue(response.body())
            }
        }
        errorMessage.value = false.toString()
    }
}