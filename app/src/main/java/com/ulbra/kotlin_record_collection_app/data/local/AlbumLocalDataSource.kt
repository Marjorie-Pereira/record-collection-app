package com.ulbra.kotlin_record_collection_app.data.local

import com.ulbra.kotlin_record_collection_app.data.local.dao.AlbumDao
import com.ulbra.kotlin_record_collection_app.data.local.entities.AlbumEntity
import kotlinx.coroutines.flow.Flow

class AlbumLocalDataSource(private val albumDao: AlbumDao) {
    fun getAllAlbums(): Flow<List<AlbumEntity>> = albumDao.getAllAlbums()

    suspend fun addAlbum(album: AlbumEntity) {
        albumDao.insert(album)
    }

    suspend fun deleteAlbum(album: AlbumEntity) {
        albumDao.delete(album)
    }

}