package com.ulbra.kotlin_record_collection_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ulbra.kotlin_record_collection_app.data.AlbumRepository
import com.ulbra.kotlin_record_collection_app.data.model.Album
import com.ulbra.kotlin_record_collection_app.ui.adapter.AlbumAdapter

class MainActivity : AppCompatActivity() {

    private val repository = AlbumRepository()
    private lateinit var adapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rc = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = AlbumAdapter(
            onDelete = { album ->
                deleteAlbum(rc, album)
            },
            onDetails = { album ->
                goToDetails(album = album)
            }
        )
        rc.adapter = adapter

        adapter.submitList(repository.getAlbums())
    }

    private fun deleteAlbum(recyclerView: RecyclerView, album: Album) : Boolean {

        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage("Deletar o item?")
        alertDialogBuilder.setPositiveButton("Sim") { dialog, which ->

            val newList = repository.getAlbums().toMutableList()

            newList.remove(album)

            repository.albumList = newList
            adapter.submitList(newList)

            Snackbar.make(this, recyclerView, "Deletado com sucesso!", Snackbar.LENGTH_LONG).show()

        }

        alertDialogBuilder.setNegativeButton("Não") {dialog, which -> }

        alertDialogBuilder.show()

        return true

    }

    private fun goToDetails(album: Album) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            this.putExtras(bundleOf("album" to album))
        }
        startActivity(intent)
    }

}
