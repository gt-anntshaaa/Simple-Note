package com.example.simplenote.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.simplenote.data.local.entity.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM Note")
    fun getAllNote(): LiveData<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)

    @Update
    suspend fun update(note: NoteEntity)
}