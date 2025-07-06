package com.ulbra.kotlin_record_collection_app.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class AlbumEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val artist: String,
    val year: String,
    val genre: String,
    val price: Double,
    val cover: Int
)