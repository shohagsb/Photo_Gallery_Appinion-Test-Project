package me.shohag.appiniontestproject.photo_gallery.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.shohag.appiniontestproject.photo_gallery.data.model.PhotoResponse
import me.shohag.appiniontestproject.photo_gallery.data.repository.GalleryRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: GalleryRepository
) : ViewModel() {
    private val _photos = MutableLiveData<PhotoResponse>()
    val photos: LiveData<PhotoResponse>
        get() = _photos

    init {
        getPhotos(DEFAULT_QUERY)
    }


    fun getPhotos(query: String) {
        viewModelScope.launch {
            repository.getPhotos(query)
                .catch {
                    Timber.d("GalleryVM: %s", it.message)
                }
                .collect { photoResponse ->
                    _photos.value = photoResponse
                }
        }
    }

    companion object{
        private const val DEFAULT_QUERY ="cats"
    }

}