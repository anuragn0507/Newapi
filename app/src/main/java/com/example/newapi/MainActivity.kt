package com.example.newapi

import retrofit2.Call
import retrofit2.Retrofit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Response
import javax.security.auth.callback.Callback


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadlines("in",1)
        news.enqueue(object : retrofit2.Callback<News>{
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Multitasker", "Error in Fetching News", t)

            }

           override fun onResponse(call: Call<News>, response: Response<News>) {
               val news = response.body()
               if (news != null) {
                   Log.d("Welcome to Multitaskers", news.toString())

               }

           }
        })

    }
}

