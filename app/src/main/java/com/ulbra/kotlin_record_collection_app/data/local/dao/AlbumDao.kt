package com.ulbra.kotlin_record_collection_app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ulbra.kotlin_record_collection_app.data.local.entities.AlbumEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: AlbumEntity)

    @Update
    suspend fun update(user: AlbumEntity)

    @Query("SELECT * FROM albums")
    fun getAllAlbums(): Flow<List<AlbumEntity>>

    @Delete
    suspend fun delete(user: AlbumEntity)
}