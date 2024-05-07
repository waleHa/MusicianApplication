package com.example.musicianapplication.domain.remotemodel.Musician


import com.google.gson.annotations.SerializedName

data class MusicianListResponseModel(
    @SerializedName("resultCount")
    val resultCount: Int? = 0,
    @SerializedName("results")
    val musicianItemResponseModels: List<MusicianItemResponseModel?>? = listOf()
)