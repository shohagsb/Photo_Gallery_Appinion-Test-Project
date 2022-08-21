package me.shohag.appiniontestproject.photo_gallery.ui.gallery

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import me.shohag.appiniontestproject.R
import me.shohag.appiniontestproject.databinding.FragmentGalleryBinding
import me.shohag.appiniontestproject.photo_gallery.adapter.GalleryAdapter
import me.shohag.appiniontestproject.photo_gallery.adapter.PhotoListener


@AndroidEntryPoint
class GalleryFragment : Fragment() {
    private lateinit var _binding: FragmentGalleryBinding
    private val viewModel: GalleryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(layoutInflater)
        setHasOptionsMenu(true)
        getPhotos()

        return _binding.root
    }

    /**
     * Recycler-View Adapter
     * */
    private val adapter = GalleryAdapter(PhotoListener {
        this@GalleryFragment.findNavController().navigate(
            GalleryFragmentDirections.actionGalleryFragmentToPhotoFragment(it)
        )
    })

    /**
     * Get Photos
     * */
    private fun getPhotos() {
        viewModel.photos.observe(viewLifecycleOwner) {
            it?.let {
                adapter.submitList(it.results)
                _binding.recyclerView.adapter = adapter
            }
        }
    }

    /**
     * Handling Search actions
     * */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    _binding.recyclerView.scrollToPosition(0)
                    viewModel.getPhotos(query)
                    searchView.clearFocus()
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

        })
    }
}