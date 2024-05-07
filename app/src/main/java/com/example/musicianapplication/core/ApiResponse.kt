package com.example.musicianapplication.core

import com.example.musicianapplication.domain.remotemodel.Musician.MusicianListResponseModel

sealed class ApiResponse<out T> {
    data class SuccessState<out T>(val data: T) : ApiResponse<T>()
    data class ErrorState(val message: String) : ApiResponse<Nothing>()
    object Loading:ApiResponse<Nothing>()
}