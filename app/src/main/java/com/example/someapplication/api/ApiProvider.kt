package com.example.someapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {
    fun provide(): DogFactsApi {
        return Retrofit.Builder()
            .baseUrl("https://dog-api.kinduff.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogFactsApi::class.java)
    }
}