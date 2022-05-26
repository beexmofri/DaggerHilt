package com.test.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.test.mvvmretrofit.databinding.ActivityMainBinding
import com.test.mvvmretrofit.di.ApiService
import com.test.mvvmretrofit.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding



    lateinit var viewModel: MainViewModel

    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMovieList(it)
        })

        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllMovies()
    }
}
