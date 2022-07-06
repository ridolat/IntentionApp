package com.example.intentionapp2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intentionapp2.model.MainRepository
import com.example.intentionapp2.model.Quote
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel (private val repository: MainRepository) : ViewModel() {

    val quoteList = MutableLiveData<List<Quote>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllQuotes(){
        val response = repository.getAllQuotes()
        response.enqueue(object: Callback<List<Quote>>{

            override fun onResponse(call: Call<List<Quote>>, response: Response<List<Quote>>) {
                if(response?.body() != null)
                quoteList.postValue(response.body()!!)
            }

            override fun onFailure(call: Call<List<Quote>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}
