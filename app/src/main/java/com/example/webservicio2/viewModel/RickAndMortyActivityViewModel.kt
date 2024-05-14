package com.example.webservicio2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webservicio2.models.RickAndMortyApi.Characters
import com.example.webservicio2.network.RetroFitObject
import kotlinx.coroutines.launch
import android.util.Log
import retrofit2.Retrofit

class RickAndMortyActivityViewModel : ViewModel() {
    private val _characters = MutableLiveData<Characters>()
    val characters: LiveData<Characters> get() = _characters

    fun getCharacters() {
        viewModelScope.launch {
            try {
                val result = RetroFitObject.url_rickandmorty.getCharacters()
                Log.d("RickAndMortyActivityViewModel", "Data received: $result")
                _characters.postValue(result)
            } catch (e: Exception) {
                Log.e("RickAndMortyActivityViewModel", "Error fetching data: ${e.message}")
                // Puedes manejar el error aquí, por ejemplo, actualizando un LiveData de estado de error
            }
        }
    }
}