package com.ulbra.kotlin_record_collection_app.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.ulbra.kotlin_record_collection_app.data.model.Album
import com.ulbra.kotlin_record_collection_app.databinding.FragmentRecordListBinding
import com.ulbra.kotlin_record_collection_app.ui.adapter.AlbumAdapter
import com.ulbra.kotlin_record_collection_app.ui.viewmodel.AlbumViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RecordListFragment : Fragment() {
    private lateinit var binding: FragmentRecordListBinding
    private lateinit var adapter: AlbumAdapter
    private val albumViewModel: AlbumViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        albumViewModel.albumList.observe(viewLifecycleOwner) { album ->
            adapter.submitList(album.toMutableList())

        }
        // Inflate the layout for this fragment
        binding = FragmentRecordListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rc = binding.recyclerView
        val alertDialogBuilder = AlertDialog.Builder(view.context)
        alertDialogBuilder.setMessage("Deletar o item?")

        adapter = AlbumAdapter(
            onDelete = { album ->
                albumViewModel.removeAlbum(album)
            },
            onDetails = { album ->
                goToDetails(album = album)
            },
            onLongClick = {album ->
                showDeleteConfirmation(album)
            }
        )
        rc.adapter = adapter

        binding.fabAdd.setOnClickListener {
            val action = RecordListFragmentDirections.actionRecordListFragmentToAlbumFormFragment(null)
            findNavController().navigate(action)
        }
    }

    private fun goToDetails(album: Album) {
        val action = RecordListFragmentDirections.actionRecordListFragmentToAlbumDetailsFragment(album)
        findNavController().navigate(action)
    }

    private fun showDeleteConfirmation(album: Album) {
        AlertDialog.Builder(requireContext())
            .setTitle("Excluir álbum")
            .setMessage("Tem certeza de que deseja excluir o item?")
            .setPositiveButton("Sim") { _, _ ->
                viewLifecycleOwner.lifecycleScope.launch {
                    albumViewModel.removeAlbum(album)
                    Snackbar.make(requireView(), "Item deletado!", Snackbar.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

}