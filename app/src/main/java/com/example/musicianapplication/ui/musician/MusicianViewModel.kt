package com.example.musicianapplication.ui.musician

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicianapplication.domain.Repository.Musician.MusicianRepository
import com.example.musicianapplication.domain.remotemodel.Musician.MusicianItemRemoteModel
import com.example.musicianapplication.domain.remotemodel.Musician.MusicianListRemoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MusicianViewModel @Inject constructor(private val musicianRepository: MusicianRepository) :
    ViewModel() {
    val TAG = "TAG: MusicianViewModel"
    private var _musicianListSuccess = MutableLiveData<MusicianListRemoteModel>()
    val musicianListSuccess: LiveData<MusicianListRemoteModel> = _musicianListSuccess

    private val _musicianListError = MutableLiveData<String>()
    val musicianListError: LiveData<String> = _musicianListError

    private val _loading = MutableLiveData<Boolean>(true)
    val loading: LiveData<Boolean> = _loading

    init {
        getMusician()
    }

    fun getMusician() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = musicianRepository.getMusicianFromRemoteDataSource()
                if (response.isSuccessful) {
                    _musicianListSuccess.postValue(response.body())
                } else {
                    _musicianListError.postValue(response.errorBody().toString())
                }
            } catch (e: Exception) {
                _musicianListError.postValue(e.localizedMessage)
            } finally {
                _loading.postValue(false)
                Log.i(TAG, "finally")
            }
        }
    }
}