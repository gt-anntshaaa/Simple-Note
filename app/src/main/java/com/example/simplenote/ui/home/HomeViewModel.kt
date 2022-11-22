package com.example.simplenote.ui.home

import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.simplenote.data.local.NoteDatabaseApplication
import com.example.simplenote.data.local.entity.NoteEntity
import com.example.simplenote.data.repository.NoteRepo
import com.example.simplenote.data.repository.NoteRepoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val repo: NoteRepoImpl) : ViewModel() {

    var listNote: LiveData<List<NoteEntity>>

    init {
        listNote = repo.getAllNote()
    }

    // TODO: KEMUNGKINAN EROR
//    fun doGetList(){
//        val listNote = repo.getAllNote()
//    }

    fun doInsert(note: NoteEntity) = viewModelScope.launch(Dispatchers.IO) {
        repo.InsertNote(note)
    }


    fun doUpdate(note: NoteEntity) = viewModelScope.launch(Dispatchers.IO) {
        repo.UpdateNote(note)
    }
    
    fun doDelete(note: NoteEntity) = viewModelScope.launch(Dispatchers.IO) {
        repo.DeleteNote(note)
    }

}