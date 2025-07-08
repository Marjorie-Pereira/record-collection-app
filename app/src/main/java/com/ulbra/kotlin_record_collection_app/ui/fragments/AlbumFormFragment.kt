package com.ulbra.kotlin_record_collection_app.ui.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ulbra.kotlin_record_collection_app.R
import com.ulbra.kotlin_record_collection_app.data.model.Album
import com.ulbra.kotlin_record_collection_app.databinding.FragmentAlbumFormBinding
import com.ulbra.kotlin_record_collection_app.ui.viewmodel.AlbumViewModel


class AlbumFormFragment : Fragment() {
    private lateinit var binding: FragmentAlbumFormBinding
    private val albumViewModel: AlbumViewModel by viewModels()
    private var selectedImageUri: Uri? = null

    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            selectedImageUri = it
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAlbumFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.selectImageBtn.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        binding.addButton.setOnClickListener {
            val album = Album(
                title = binding.txvTitle.text.toString(),
                artist = binding.txvArtist.text.toString(),
                year = binding.txvYear.text.toString(),
                genre = binding.txvGenre.text.toString(),
                price = binding.txvPrice.text.toString().toDoubleOrNull() ?: 0.0,
                cover = selectedImageUri?.toString()
            )
            albumViewModel.addAlbum(album)
            val action = AlbumFormFragmentDirections.actionAlbumFormFragmentToRecordListFragment()
            findNavController().navigate(action)
        }
    }

}