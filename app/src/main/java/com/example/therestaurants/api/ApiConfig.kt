package com.example.therestaurants.api

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        fun getApiService() : ApiService {
            val client = OkHttpClient.Builder().build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://restaurant-api.dicoding.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}