package com.rohitss.news.homeMVP.dataModel

import com.google.gson.annotations.SerializedName

data class NewsResponse(

        @field:SerializedName("totalResults")
        val totalResults: Int? = null,

        @field:SerializedName("articles")
        val articles: List<ArticlesItem?>? = null,

        @field:SerializedName("status")
        val status: String? = null
)