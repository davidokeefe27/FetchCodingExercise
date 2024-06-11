package com.example.fetchcodingexercise.api

import com.example.fetchcodingexercise.models.DataModel
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("hiring.json")
    suspend fun getData(): Response<List<DataModel>>

}