package com.example.webservicio2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webservicio2.models.RickAndMortyApi.Characters
import com.example.webservicio2.network.RetroFitObject
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class RickAndMortyActivityViewModel : ViewModel() {
    private val _characters = MutableLiveData<Characters>()
    public val characters : LiveData<Characters> get() = _characters
    fun getCharacters(){
        viewModelScope.launch {
            val result = RetroFitObject.url_rickandmorty.getCharacters()
            _characters.postValue(result)
        }
    }
}