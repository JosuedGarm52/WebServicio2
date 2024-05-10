package com.example.webservicio2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.webservicio2.models.RandomUser.RandomUse
import com.example.webservicio2.network.RetroFitObject
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val _randomUser = MutableLiveData<RandomUse>()
    val randomUser: LiveData<RandomUse> get() = _randomUser

    fun getRandomUser() {
        viewModelScope.launch {
            val randomUser: RandomUse = RetroFitObject.randomApi.getRandomUser()
            _randomUser.postValue(randomUser)
        }
    }
}
