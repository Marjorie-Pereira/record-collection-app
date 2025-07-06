package com.ulbra.kotlin_record_collection_app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import com.ulbra.kotlin_record_collection_app.data.local.entities.AlbumEntity

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: AlbumEntity)

    @Query("SELECT * FROM albums")
    fun getAllAlbums(): Flow<List<AlbumEntity>>

    @Delete
    suspend fun delete(user: AlbumEntity)
}