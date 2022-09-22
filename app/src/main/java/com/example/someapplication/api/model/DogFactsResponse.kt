package com.example.someapplication.api.model

data class DogFactsResponse(
    val facts: List<String>,
    val success: Boolean
)
