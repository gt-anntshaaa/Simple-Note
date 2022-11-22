package com.example.simplenote.data.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "Note")
@Parcelize
data class NoteEntity(
    @ColumnInfo(name = "Title") val title: String,
    @ColumnInfo(name = "Description") val description: String
) : Parcelable{
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
