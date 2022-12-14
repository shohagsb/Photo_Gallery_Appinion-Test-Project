package me.shohag.appiniontestproject.photo_gallery.data.services

import me.shohag.appiniontestproject.BuildConfig
import me.shohag.appiniontestproject.photo_gallery.data.model.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GalleryServices {
    companion object{
        private const val CLIENT_ID = BuildConfig.UNSPLASH_ACESS_KEY
    }

    /**
     * Get searched photo from Unplash API
     * @param
     * query : String
     *
     * @return
     * PhotoResponse
     * */
    @Headers("Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun getPhotos(
        @Query ("query")  query: String,
    ) : PhotoResponse
}