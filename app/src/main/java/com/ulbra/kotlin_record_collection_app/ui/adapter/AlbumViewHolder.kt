package com.ulbra.kotlin_record_collection_app.ui.adapter


import androidx.recyclerview.widget.RecyclerView
import com.ulbra.kotlin_record_collection_app.data.model.Album
import com.ulbra.kotlin_record_collection_app.databinding.AlbumBinding
import kotlinx.coroutines.Job

class AlbumViewHolder(
    private val binding: AlbumBinding,
    private val onDetails: (Album) -> Unit,
    private val onLongClick: (Album) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(album: Album) {
        binding.album = album
        binding.executePendingBindings()

        binding.albumCard.setOnClickListener {
            onDetails(album)
        }

        binding.albumCard.setOnLongClickListener {
            onLongClick(album)
            true

        }
    }

}