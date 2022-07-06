package com.example.intentionapp2.model

import com.google.gson.annotations.SerializedName

data class Quote(

    @SerializedName("q")
    val quotation: String,

    @SerializedName("a")
    val author_name: String,

    @SerializedName("c")
    val character_count: Int,

    @SerializedName("h")
    val html_quote: String,


)
