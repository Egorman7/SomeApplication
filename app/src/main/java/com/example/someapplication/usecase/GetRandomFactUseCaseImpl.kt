package com.example.someapplication.usecase

import com.example.someapplication.api.DogFactsApi
import com.example.someapplication.api.wrapper.ApiResponse

class GetRandomFactUseCaseImpl(private val api: DogFactsApi) : GetRandomFactUseCase {
    override suspend fun getRandomFact(): ApiResponse<String> {
        return try {
            val response = api.fetRandomDogFact()
            if(response.success){
                ApiResponse.Success(response.facts.first())
            } else {
                ApiResponse.Error("Internal server error!")
            }
        } catch (e: Exception){
            ApiResponse.Error(e.message)
        }
    }
}