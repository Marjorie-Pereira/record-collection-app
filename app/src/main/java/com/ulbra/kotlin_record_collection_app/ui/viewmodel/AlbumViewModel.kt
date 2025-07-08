package com.ulbra.kotlin_record_collection_app.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ulbra.kotlin_record_collection_app.data.AlbumRepository
import com.ulbra.kotlin_record_collection_app.data.local.AlbumLocalDataSource
import com.ulbra.kotlin_record_collection_app.data.local.database.AppDatabase
import com.ulbra.kotlin_record_collection_app.data.model.Album
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumViewModel(application: Application) : AndroidViewModel(application) {
    private val albumDao = AppDatabase.getInstance(application).albumDao()
    private val localDataSource = AlbumLocalDataSource(albumDao)
    private val repository = AlbumRepository(localDataSource)

    private val _albumList = repository.getAllAlbums().asLiveData()
    val albumList: LiveData<List<Album>> = _albumList

    init {
        repository.getAllAlbums()
    }

    fun removeAlbum(album: Album) = viewModelScope.launch(Dispatchers.IO) {
        repository.remove(album)
    }

    fun addAlbum(album: Album) = viewModelScope.launch(Dispatchers.IO) {
        repository.add(album)
    }


}