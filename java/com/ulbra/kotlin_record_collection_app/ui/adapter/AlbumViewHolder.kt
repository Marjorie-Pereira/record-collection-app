package com.ulbra.kotlin_record_collection_app.ui.adapter

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.ulbra.kotlin_record_collection_app.R
import com.ulbra.kotlin_record_collection_app.data.model.Album

class AlbumViewHolder (
    // layout do item da lista
    itemView: View,
    private val onDelete: (Album) -> Boolean,
    private val onDetails: (Album) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val albumCard: MaterialCardView = itemView.findViewById(R.id.albumCard)
    private val title: TextView = itemView.findViewById(R.id.albumTitle)
    private val price: TextView = itemView.findViewById(R.id.price)
    private val image: ImageView = itemView.findViewById(R.id.albumCover)

    fun bind(album: Album) {
        title.text = album.title
        price.text = album.price.toString()
        image.setImageResource(album.cover)

        albumCard.setOnClickListener {
            onDetails(album)
        }

        albumCard.setOnLongClickListener {
            onDelete(album)
        }
    }

}