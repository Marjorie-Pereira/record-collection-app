package com.ulbra.kotlin_record_collection_app.data

import com.ulbra.kotlin_record_collection_app.data.local.AlbumLocalDataSource
import com.ulbra.kotlin_record_collection_app.data.mappers.convertToEntity
import com.ulbra.kotlin_record_collection_app.data.mappers.convertToModel
import com.ulbra.kotlin_record_collection_app.data.model.Album
import kotlinx.coroutines.flow.map

class AlbumRepository(private val dataSource: AlbumLocalDataSource)  {

    fun getAllAlbums() =
        dataSource.getAllAlbums().map { entities -> entities.map { it.convertToModel() } }

    suspend fun remove(album: Album) = dataSource.deleteAlbum(album.convertToEntity())
    suspend fun add(album: Album) = dataSource.addAlbum(album.convertToEntity())
}