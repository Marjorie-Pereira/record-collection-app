package com.ulbra.kotlin_record_collection_app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.ulbra.kotlin_record_collection_app.R
import com.ulbra.kotlin_record_collection_app.databinding.FragmentAlbumDetailsBinding


class AlbumDetailsFragment : Fragment() {
    val args: AlbumDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentAlbumDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAlbumDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumArgs = args.album
        binding.album = albumArgs

    }

}