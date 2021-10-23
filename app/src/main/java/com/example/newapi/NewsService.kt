package com.example.newapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://newsapi.org/v2/everything?q=tesla&from=2021-09-22&sortBy=publishedAt&apiKey=4ceb1db1b4d8415498f04a98fdec730c
 // https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=4ceb1db1b4d8415498f04a98fdec730c
// https://newsapi.org/v2/top-headlines?country=in&apiKey=4ceb1db1b4d8415498f04a98fdec730c

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "4ceb1db1b4d8415498f04a98fdec730c"
interface NewsInterface{

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String,@Query ("page") page: Int): Call<News>
    //http://newsapi.org/v2/top-headlines?apiKey=$API_KEY&country=in&page=1

}

object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}