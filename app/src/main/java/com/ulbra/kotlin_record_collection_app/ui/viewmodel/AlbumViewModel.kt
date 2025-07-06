package com.ulbra.kotlin_record_collection_app.ui.viewmodel

import android.app.AlertDialog
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ulbra.kotlin_record_collection_app.data.AlbumRepository
import com.ulbra.kotlin_record_collection_app.data.model.Album

class AlbumViewModel : ViewModel() {
    private val repository = AlbumRepository()

    private val _albumList = MutableLiveData<List<Album>>()
    val albumList: LiveData<List<Album>> = _albumList

    init {
        _albumList.value = repository.getAlbums()
    }

    fun deleteAlbum(view: View, recyclerView: RecyclerView, album: Album) : Boolean {

        val alertDialogBuilder = AlertDialog.Builder(view.context)
        alertDialogBuilder.setMessage("Deletar o item?")
        alertDialogBuilder.setPositiveButton("Sim") { _, _ ->

            val newList = repository.getAlbums().toMutableList()

            newList.remove(album)

            repository.albumList = newList
            _albumList.value = newList.toList()

            Snackbar.make(view.context, recyclerView, "Deletado com sucesso!", Snackbar.LENGTH_LONG).show()

        }

        alertDialogBuilder.setNegativeButton("Não") {_, _ -> }

        alertDialogBuilder.show()

        return true

    }
}