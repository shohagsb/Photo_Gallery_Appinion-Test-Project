package me.shohag.appiniontestproject.photo_gallery.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhotoDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg photo: PhotoEntity)

    @Query("SELECT * FROM photo_gallery_table")
    suspend  fun getAllPhotos(): LiveData<List<PhotoEntity>>

    @Query("DELETE FROM photo_gallery_table")
    suspend  fun clear()
}