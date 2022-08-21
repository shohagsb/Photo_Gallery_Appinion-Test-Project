package me.shohag.appiniontestproject.photo_gallery.ui.photo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import me.shohag.appiniontestproject.R
import me.shohag.appiniontestproject.databinding.FragmentPhotoBinding
import me.shohag.appiniontestproject.photo_gallery.data.model.PhotoResponse

@AndroidEntryPoint
class PhotoFragment : Fragment() {
    private lateinit var _binding: FragmentPhotoBinding
    private val viewModel: PhotoViewModel by viewModels()
    private lateinit var photo: PhotoResponse.UnsplashPhoto

    private val args: PhotoFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photo = args.unsplashPhoto
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoBinding.inflate(layoutInflater)
        _binding.lifecycleOwner = this
        _binding.photo = photo


        return _binding.root
    }


}