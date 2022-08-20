package me.shohag.appiniontestproject.photo_gallery.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import me.shohag.appiniontestproject.photo_gallery.data.model.PhotoResponse
import me.shohag.appiniontestproject.photo_gallery.data.services.GalleryServices
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GalleryRepository @Inject constructor(
    private val services: GalleryServices
) {

    fun getPhotos(query: String): Flow<PhotoResponse> = flow {
        val photos = services.getPhotos(query)
        emit(photos)
    }.flowOn(Dispatchers.IO)

}