package com.example.simplenote.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.simplenote.data.local.dao.NoteDao
import com.example.simplenote.data.local.entity.NoteEntity

@Database(entities = arrayOf(NoteEntity::class), version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object{
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    NoteDatabase::class.java,
                    "note_db"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}