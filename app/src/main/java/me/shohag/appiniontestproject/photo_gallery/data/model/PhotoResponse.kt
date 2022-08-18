package me.shohag.appiniontestproject.photo_gallery.data.model

data class PhotoResponse(
    val results : List<UnsplashPhoto>
){
    data class UnsplashPhoto(
        val id : String
    )
}
