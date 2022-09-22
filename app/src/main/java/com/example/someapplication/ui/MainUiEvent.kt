package com.example.someapplication.ui

sealed interface MainUiEvent {
    object Loading : MainUiEvent
    class Fact(val content: String): MainUiEvent
    class Error(val message: String) : MainUiEvent
}