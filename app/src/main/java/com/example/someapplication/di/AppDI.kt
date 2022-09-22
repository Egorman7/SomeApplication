package com.example.someapplication.di

import com.example.someapplication.api.ApiProvider
import com.example.someapplication.api.DogFactsApi
import com.example.someapplication.ui.MainViewModel
import com.example.someapplication.usecase.GetRandomFactUseCase
import com.example.someapplication.usecase.GetRandomFactUseCaseImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppDI {
    private val viewModelModule = module {
        viewModel { MainViewModel(androidApplication(), get()) }
    }

    private val useCaseModule = module {
        single<GetRandomFactUseCase> { GetRandomFactUseCaseImpl(get()) }
    }

    private val apiModule = module {
        single<DogFactsApi> { ApiProvider.provide() }
    }

    fun getAppModules() = listOf(viewModelModule, useCaseModule, apiModule)
}