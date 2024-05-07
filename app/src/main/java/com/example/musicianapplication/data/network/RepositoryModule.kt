package com.example.musicianapplication.data.network

import com.example.musicianapplication.domain.Repository.Musician.MusicianRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRoomRepository(musicianApiService: MusicianApiService): MusicianRepository = MusicianRepository(musicianApiService)
}