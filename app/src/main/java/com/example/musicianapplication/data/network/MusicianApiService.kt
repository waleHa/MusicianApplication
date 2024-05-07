package com.example.musicianapplication.data.network

import com.example.musicianapplication.core.Constants
import com.example.musicianapplication.domain.remotemodel.Musician.MusicianListResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface MusicianApiService {
    @GET(Constants.END_POINT)
    suspend fun getMusicianFromRemoteDataSource(): Response<MusicianListResponseModel>
}