package com.ulbra.kotlin_record_collection_app.data.mappers

import com.ulbra.kotlin_record_collection_app.data.local.entities.AlbumEntity
import com.ulbra.kotlin_record_collection_app.data.model.Album

fun Album.convertToEntity() =
    AlbumEntity(
        title = this.title,
        artist = this.artist,
        year = this.year,
        genre = this.genre,
        price = this.price,
        cover = this.cover
    )

fun AlbumEntity.convertToModel() =
    Album(
        id = this.id,
        title = this.title,
        artist = this.artist,
        year = this.year,
        genre = this.genre,
        price = this.price,
        cover = this.cover
    )