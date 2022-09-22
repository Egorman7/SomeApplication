package com.example.someapplication.api

import com.example.someapplication.api.model.DogFactsResponse
import retrofit2.http.GET

interface DogFactsApi {
    @GET("facts")
    suspend fun fetRandomDogFact() : DogFactsResponse
}