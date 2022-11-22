package com.example.simplenote.data.repository

import androidx.lifecycle.LiveData
import com.example.simplenote.data.local.entity.NoteEntity

interface NoteRepo {
    fun getAllNote(): LiveData<List<NoteEntity>>
    suspend fun InsertNote(note: NoteEntity)
    suspend fun UpdateNote(note: NoteEntity)
    suspend fun DeleteNote(note: NoteEntity)
}