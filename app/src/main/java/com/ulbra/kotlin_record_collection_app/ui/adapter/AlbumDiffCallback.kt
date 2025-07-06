package com.ulbra.kotlin_record_collection_app.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ulbra.kotlin_record_collection_app.data.model.Album

class AlbumDiffCallback : DiffUtil.ItemCallback<Album>(){
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }
}