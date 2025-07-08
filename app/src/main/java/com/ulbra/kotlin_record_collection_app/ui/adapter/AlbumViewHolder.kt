package com.ulbra.kotlin_record_collection_app.ui.adapter


import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ulbra.kotlin_record_collection_app.data.model.Album
import com.ulbra.kotlin_record_collection_app.databinding.AlbumBinding
import com.ulbra.kotlin_record_collection_app.databinding.FragmentRecordListBinding
import com.ulbra.kotlin_record_collection_app.ui.fragments.RecordListFragment
import kotlinx.coroutines.Job

class AlbumViewHolder(
    private val binding: AlbumBinding,
    private val onDelete: (Album) -> Job,
    private val onDetails: (Album) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private val alertDialogBuilder = AlertDialog.Builder(binding.root.context)

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