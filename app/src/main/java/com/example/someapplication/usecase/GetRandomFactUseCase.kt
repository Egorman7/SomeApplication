package com.example.someapplication.usecase

import com.example.someapplication.api.wrapper.ApiResponse

interface GetRandomFactUseCase {
    suspend fun getRandomFact(): ApiResponse<String>
}