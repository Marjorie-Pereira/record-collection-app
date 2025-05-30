package com.ulbra.kotlin_record_collection_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ulbra.kotlin_record_collection_app.R
import com.ulbra.kotlin_record_collection_app.data.model.Album

class AlbumAdapter(
    private val onDelete: (Album) -> Boolean,
    private val onDetails: (Album) -> Unit
) : ListAdapter<Album, AlbumViewHolder>(AlbumDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.album, parent, false)

        return AlbumViewHolder(itemView = itemView, onDelete = onDelete, onDetails = onDetails)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}