package com.ulbra.kotlin_record_collection_app.data.model

import java.io.Serializable

data class Album (
    val id: Int,
    val title: String,
    val artist: String,
    val year: String,
    val genre: String,
    val price: Double,
    val cover: Int
) : Serializable