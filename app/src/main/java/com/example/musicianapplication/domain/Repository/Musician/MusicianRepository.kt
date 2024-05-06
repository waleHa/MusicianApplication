package com.example.musicianapplication.domain.Repository.Musician

import com.example.musicianapplication.data.network.MusicianApiService
import javax.inject.Inject


class MusicianRepository @Inject constructor(private val musicianApiService: MusicianApiService){
    suspend fun getMusicianFromRemoteDataSource() = musicianApiService.getMusicianFromRemoteDataSource()
}