package me.shohag.appiniontestproject.photo_gallery.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import me.shohag.appiniontestproject.photo_gallery.data.model.PhotoResponse
import me.shohag.appiniontestproject.photo_gallery.data.services.GalleryServices
import javax.inject.Inject

class GalleryRepository @Inject constructor(
    private val services: GalleryServices
) {
    fun getPhotos(query: String, page: Int, perPage: Int): Flow<PhotoResponse> = flow {
        val photos = services.getPhotos(query, page, perPage)
        emit(photos)
    }.flowOn(Dispatchers.IO)

}