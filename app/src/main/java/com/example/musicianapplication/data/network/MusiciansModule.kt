package com.example.musicianapplication.data.network

import com.example.musicianapplication.core.Constants
import com.example.musicianapplication.domain.Repository.Musician.MusicianRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MusiciansModule {
    @Singleton
    @Provides
    fun provideMusicianApiService():MusicianApiService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MusicianApiService::class.java)

    @Singleton
    @Provides
    fun provideRepository() :MusicianRepository = MusicianRepository(provideMusicianApiService())
}