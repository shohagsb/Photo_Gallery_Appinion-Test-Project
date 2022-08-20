package me.shohag.appiniontestproject.photo_gallery.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PhotoDatabaseDao {
    @Insert
    suspend  fun insert(photo: PhotoEntity)

    @Query("SELECT * FROM photo_gallery_table")
    suspend  fun getAllPhotos(): LiveData<List<PhotoEntity>>

    @Query("DELETE FROM photo_gallery_table")
    suspend  fun clear()
}