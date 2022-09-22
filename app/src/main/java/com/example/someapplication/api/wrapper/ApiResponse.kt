package com.example.someapplication.api.wrapper

sealed class ApiResponse<T>(val data: T?, val message: String? = null){
    class Success<T>(data: T) : ApiResponse<T>(data)
    class Error<T>(message: String?) : ApiResponse<T>(null, message)
}
