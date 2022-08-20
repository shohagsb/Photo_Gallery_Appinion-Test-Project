package me.shohag.appiniontestproject.photo_gallery.data.database

import androidx.room.Database

@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)
abstract class PhotoDatabase {

}