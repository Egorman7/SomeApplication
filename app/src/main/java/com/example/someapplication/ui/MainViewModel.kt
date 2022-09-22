package com.example.someapplication.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.someapplication.api.wrapper.ApiResponse
import com.example.someapplication.usecase.GetRandomFactUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(app: Application, private val randomFactUseCase: GetRandomFactUseCase): AndroidViewModel(app) {
    private val context: Context by lazy { app }

    private val _uiEvents = MutableLiveData<MainUiEvent>()
    val uiEvents: LiveData<MainUiEvent> get() = _uiEvents

    fun getRandomFact(){
        viewModelScope.launch(Dispatchers.IO){
            when(val factResponse = randomFactUseCase.getRandomFact()){
                is ApiResponse.Success -> {
                    postEvent(MainUiEvent.Fact(factResponse.data ?: ""))
                }
                is ApiResponse.Error -> {
                    postEvent(MainUiEvent.Error(factResponse.message ?: "Unknown error"))
                }
            }
        }
    }

    private fun postEvent(event: MainUiEvent){
        _uiEvents.postValue(event)
    }
}