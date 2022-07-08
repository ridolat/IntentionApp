package com.example.intentionapp2.model

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllQuotes() = retrofitService.getQuotes()
    fun getQOTD() = retrofitService.getQuoteOfTheDay()
}