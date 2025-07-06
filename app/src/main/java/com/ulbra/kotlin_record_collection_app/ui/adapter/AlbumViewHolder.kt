package com.ulbra.kotlin_record_collection_app.ui.adapter


import androidx.recyclerview.widget.RecyclerView
import com.ulbra.kotlin_record_collection_app.data.model.Album
import com.ulbra.kotlin_record_collection_app.databinding.AlbumBinding

class AlbumViewHolder (
    private val binding: AlbumBinding,
    private val onDelete: (Album) -> Boolean,
    private val onDetails: (Album) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(album: Album) {
        binding.album = album
        binding.executePendingBindings()

        binding.albumCard.setOnClickListener {
            onDetails(album)
        }

        binding.albumCard.setOnLongClickListener {
            onDelete(album)
        }
    }

}