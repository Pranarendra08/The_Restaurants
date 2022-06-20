package com.example.therestaurants.api

import com.example.therestaurants.api
import com.example.therestaurants.api.model.ResponseDetailRestaurant
import com.example.therestaurants.api.model.ResponseListRestaurant
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("list")
    fun getListRestaurant() : Call<ResponseListRestaurant>

    @GET("detail/{id}")
    fun getDetailRestaurant(@Path("id") id: String) : Call<ResponseDetailRestaurant>

}