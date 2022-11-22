package com.example.simplenote.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplenote.R
import com.example.simplenote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}