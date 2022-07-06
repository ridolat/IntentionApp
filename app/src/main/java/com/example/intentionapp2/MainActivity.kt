package com.example.intentionapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.intentionapp2.databinding.ActivityMainBinding
import com.example.intentionapp2.model.MainRepository
import com.example.intentionapp2.model.RetrofitService
import com.example.intentionapp2.view.MainAdapter
import com.example.intentionapp2.viewmodel.MainViewModel
import com.example.intentionapp2.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get viewmodel instance using MyViewModelFactory
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        //Set RecyclerView Adapter

        binding.recyclerview.adapter = adapter

        viewModel.quoteList.observe(this, Observer {
            Log.d(TAG, "quoteList: $it")
            adapter.setQuoteList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")

        })

        viewModel.getAllQuotes()
    }
}