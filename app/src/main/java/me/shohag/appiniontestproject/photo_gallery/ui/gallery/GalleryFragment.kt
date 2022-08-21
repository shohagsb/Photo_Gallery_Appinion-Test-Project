package me.shohag.appiniontestproject.photo_gallery.ui.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import me.shohag.appiniontestproject.databinding.FragmentGalleryBinding
import me.shohag.appiniontestproject.photo_gallery.adapter.GalleryAdapter
import me.shohag.appiniontestproject.photo_gallery.adapter.PhotoListener


@AndroidEntryPoint
class GalleryFragment : Fragment() {
    private lateinit var _binding: FragmentGalleryBinding
    private val viewModel: GalleryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getPhotos("cats")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(layoutInflater)

        getPhotos()
        return _binding.root
    }

    private val adapter = GalleryAdapter(PhotoListener {
        this@GalleryFragment.findNavController().navigate(
            GalleryFragmentDirections.actionGalleryFragmentToPhotoFragment(it)
        )
    })
    private fun getPhotos() {
        viewModel.photos.observe(viewLifecycleOwner) {
            it?.let {
                adapter.submitList(it.results)
                _binding.recyclerView.adapter = adapter
            }
        }
    }
}