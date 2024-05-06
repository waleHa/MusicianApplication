package com.example.musicianapplication.domain.remotemodel.Musician


import com.google.gson.annotations.SerializedName

data class MusicianListRemoteModel(
    @SerializedName("resultCount")
    val resultCount: Int? = 0,
    @SerializedName("results")
    val musicianItemRemoteModels: List<MusicianItemRemoteModel?>? = listOf()
)