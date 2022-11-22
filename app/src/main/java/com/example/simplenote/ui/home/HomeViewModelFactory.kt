package com.example.simplenote.ui.home

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simplenote.data.local.NoteDatabase
import com.example.simplenote.data.repository.NoteRepo
import com.example.simplenote.data.repository.NoteRepoImpl

class HomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            val viewModel = HomeViewModel(
                NoteRepoImpl(NoteDatabase.getDatabase(context))
            ) as T
            return viewModel
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}