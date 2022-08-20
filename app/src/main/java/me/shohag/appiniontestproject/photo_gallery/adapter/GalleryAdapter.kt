package me.shohag.appiniontestproject.photo_gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.shohag.appiniontestproject.databinding.ItemUnsplashPhotoBinding
import me.shohag.appiniontestproject.photo_gallery.data.model.PhotoResponse

class GalleryAdapter :
    ListAdapter<PhotoResponse.UnsplashPhoto, GalleryAdapter.ViewHolder>(DiffCallback) {
    class ViewHolder private constructor(
        private val binding: ItemUnsplashPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: PhotoResponse.UnsplashPhoto) {
            binding.photo = photo
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = ItemUnsplashPhotoBinding.inflate(inflater, parent, false)
                return ViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffCallback :
        DiffUtil.ItemCallback<PhotoResponse.UnsplashPhoto>() {
        override fun areItemsTheSame(
            oldItem: PhotoResponse.UnsplashPhoto,
            newItem: PhotoResponse.UnsplashPhoto
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: PhotoResponse.UnsplashPhoto,
            newItem: PhotoResponse.UnsplashPhoto
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }
}