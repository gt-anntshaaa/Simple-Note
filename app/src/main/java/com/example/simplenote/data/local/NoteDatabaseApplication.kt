package com.example.simplenote.data.local

import android.app.Application

class NoteDatabaseApplication : Application() {
    val database: NoteDatabase by lazy {
        NoteDatabase.getDatabase(this)
    }
}