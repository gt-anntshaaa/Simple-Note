package com.example.simplenote.data.repository

import androidx.lifecycle.LiveData
import com.example.simplenote.data.local.NoteDatabase
import com.example.simplenote.data.local.entity.NoteEntity

class NoteRepoImpl(private val noteDb: NoteDatabase) : NoteRepo {
    override fun getAllNote(): LiveData<List<NoteEntity>> {
        return noteDb.getNoteDao().getAllNote()
    }

    override suspend fun InsertNote(note: NoteEntity) {
        noteDb.getNoteDao().insert(note)
    }

    override suspend fun UpdateNote(note: NoteEntity) {
        noteDb.getNoteDao().update(note)
    }

    override suspend fun DeleteNote(note: NoteEntity) {
        noteDb.getNoteDao().delete(note)
    }
}