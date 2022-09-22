package com.example.someapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.someapplication.R
import com.example.someapplication.databinding.ActivityMainBinding
import com.example.someapplication.util.simpleViewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val binding: ActivityMainBinding by simpleViewBinding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.uiEvents.observe(this) { event ->
            when(event){
                is MainUiEvent.Loading -> {
                    enableLoading(true)
                }
                is MainUiEvent.Fact -> {
                    enableLoading(false)
                    binding.randomFactText.text = event.content
                }
                is MainUiEvent.Error -> {
                    enableLoading(false)
                    Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.randomFactButton.setOnClickListener { viewModel.getRandomFact() }
    }

    private fun enableLoading(enable: Boolean){
        binding.randomFactButton.isEnabled = !enable
        binding.randomFactLoader.isVisible = enable
    }
}