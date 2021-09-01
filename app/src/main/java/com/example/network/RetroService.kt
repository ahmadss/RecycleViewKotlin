package com.example.network

import com.example.RecyclerDataList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    fun getDataFromApi(@Query("q") query: String):Call<RecyclerDataList>
}