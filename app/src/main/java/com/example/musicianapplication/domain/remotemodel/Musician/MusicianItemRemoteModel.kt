package com.example.musicianapplication.domain.remotemodel.Musician


import com.google.gson.annotations.SerializedName

data class MusicianItemRemoteModel(
    @SerializedName("artistId")
    val artistId: Int? = 0,
    @SerializedName("artistName")
    val artistName: String? = "",
    @SerializedName("artistViewUrl")
    val artistViewUrl: String? = "",
    @SerializedName("artworkUrl100")
    val artworkUrl100: String? = "",
    @SerializedName("artworkUrl30")
    val artworkUrl30: String? = "",
    @SerializedName("artworkUrl60")
    val artworkUrl60: String? = "",
    @SerializedName("collectionArtistId")
    val collectionArtistId: Int? = 0,
    @SerializedName("collectionArtistName")
    val collectionArtistName: String? = "",
    @SerializedName("collectionArtistViewUrl")
    val collectionArtistViewUrl: String? = "",
    @SerializedName("collectionCensoredName")
    val collectionCensoredName: String? = "",
    @SerializedName("collectionExplicitness")
    val collectionExplicitness: String? = "",
    @SerializedName("collectionHdPrice")
    val collectionHdPrice: Double? = 0.0,
    @SerializedName("collectionId")
    val collectionId: Int? = 0,
    @SerializedName("collectionName")
    val collectionName: String? = "",
    @SerializedName("collectionPrice")
    val collectionPrice: Double? = 0.0,
    @SerializedName("collectionViewUrl")
    val collectionViewUrl: String? = "",
    @SerializedName("contentAdvisoryRating")
    val contentAdvisoryRating: String? = "",
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("currency")
    val currency: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("discCount")
    val discCount: Int? = 0,
    @SerializedName("discNumber")
    val discNumber: Int? = 0,
    @SerializedName("hasITunesExtras")
    val hasITunesExtras: Boolean? = false,
    @SerializedName("isStreamable")
    val isStreamable: Boolean? = false,
    @SerializedName("kind")
    val kind: String? = "",
    @SerializedName("longDescription")
    val longDescription: String? = "",
    @SerializedName("previewUrl")
    val previewUrl: String? = "",
    @SerializedName("primaryGenreName")
    val primaryGenreName: String? = "",
    @SerializedName("releaseDate")
    val releaseDate: String? = "",
    @SerializedName("shortDescription")
    val shortDescription: String? = "",
    @SerializedName("trackCensoredName")
    val trackCensoredName: String? = "",
    @SerializedName("trackCount")
    val trackCount: Int? = 0,
    @SerializedName("trackExplicitness")
    val trackExplicitness: String? = "",
    @SerializedName("trackHdPrice")
    val trackHdPrice: Double? = 0.0,
    @SerializedName("trackHdRentalPrice")
    val trackHdRentalPrice: Double? = 0.0,
    @SerializedName("trackId")
    val trackId: Int? = 0,
    @SerializedName("trackName")
    val trackName: String? = "",
    @SerializedName("trackNumber")
    val trackNumber: Int? = 0,
    @SerializedName("trackPrice")
    val trackPrice: Double? = 0.0,
    @SerializedName("trackRentalPrice")
    val trackRentalPrice: Double? = 0.0,
    @SerializedName("trackTimeMillis")
    val trackTimeMillis: Int? = 0,
    @SerializedName("trackViewUrl")
    val trackViewUrl: String? = "",
    @SerializedName("wrapperType")
    val wrapperType: String? = ""
)