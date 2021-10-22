package com.example.newapi

import retrofit2.http.GET

 // https://newsapi.org/v2/everything?q=tesla&from=2021-09-22&sortBy=publishedAt&apiKey=4ceb1db1b4d8415498f04a98fdec730c
 // https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=4ceb1db1b4d8415498f04a98fdec730c
// https://newsapi.org/v2/top-headlines?country=in&apiKey=4ceb1db1b4d8415498f04a98fdec730c

const val BASE_URL = "http://newsapi.org/"
const val API_KEY = "4ceb1db1b4d8415498f04a98fdec730c"
interface NewsInterface{


    @GET("v2/top-headlines")
    fun getHeadlines(country: String, page: Int)


}