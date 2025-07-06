package com.ulbra.kotlin_record_collection_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ulbra.kotlin_record_collection_app.R
import com.ulbra.kotlin_record_collection_app.data.model.Album
import com.ulbra.kotlin_record_collection_app.databinding.AlbumBinding

class AlbumAdapter(
    private val onDelete: (Album) -> Boolean,
    private val onDetails: (Album) -> Unit
) : ListAdapter<Album, AlbumViewHolder>(AlbumDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding =
            AlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AlbumViewHolder(binding = binding, onDelete = onDelete, onDetails = onDetails)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}