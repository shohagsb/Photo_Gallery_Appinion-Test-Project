package me.shohag.appiniontestproject.photo_gallery.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_gallery_table")
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
)
