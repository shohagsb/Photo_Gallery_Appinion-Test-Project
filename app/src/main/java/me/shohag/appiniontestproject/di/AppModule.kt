package me.shohag.appiniontestproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.shohag.appiniontestproject.photo_gallery.data.remote_datasource.RemoteDataSource
import me.shohag.appiniontestproject.photo_gallery.data.services.GalleryServices
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideGalleryService(
        remoteDataSource: RemoteDataSource
    ): GalleryServices {
        return remoteDataSource.buildApi(GalleryServices::class.java)
    }
}