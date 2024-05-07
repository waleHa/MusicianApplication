package com.example.musicianapplication.ui.musician

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicianapplication.core.ApiResponse
import com.example.musicianapplication.domain.Repository.Musician.MusicianRepository
import com.example.musicianapplication.domain.remotemodel.Musician.MusicianListResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicianViewModel @Inject constructor(private val musicianRepository: MusicianRepository) :
    ViewModel() {
    val TAG = "TAG: MusicianViewModel"
    private var _musicianListResponse = MutableLiveData<ApiResponse<MusicianListResponseModel>>()
    val musicianListResponse: LiveData<ApiResponse<MusicianListResponseModel>> =
        _musicianListResponse

    init {
        getMusician()
    }

    fun getMusician() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _musicianListResponse.postValue(ApiResponse.Loading)

                val response = musicianRepository.getMusicianFromRemoteDataSource()

                if (response.isSuccessful) {
                    _musicianListResponse.postValue(ApiResponse.SuccessState(requireNotNull(response.body())))
                } else {
                    _musicianListResponse.postValue(
                        ApiResponse.ErrorState(
                            response.errorBody().toString()
                        )
                    )
                }
            } catch (e: Exception) {
                _musicianListResponse.postValue(ApiResponse.ErrorState(e.localizedMessage.toString()))
            }
        }
    }
}