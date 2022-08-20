package me.shohag.appiniontestproject.photo_gallery.ui.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import me.shohag.appiniontestproject.R
import me.shohag.appiniontestproject.databinding.FragmentGalleryBinding
import me.shohag.appiniontestproject.photo_gallery.adapter.GalleryAdapter


@AndroidEntryPoint
class GalleryFragment : Fragment() {
    private lateinit var _binding: FragmentGalleryBinding
    private val viewModel: GalleryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(layoutInflater)
        viewModel.getPhotos("cats")
        getPhotos()
        return _binding.root
    }

    private val adapter = GalleryAdapter()
    private fun getPhotos() {
        viewModel.photos.observe(viewLifecycleOwner) {
            it?.let {
                adapter.submitList(it.results)
                _binding.recyclerView.adapter = adapter
            }
        }
    }
}