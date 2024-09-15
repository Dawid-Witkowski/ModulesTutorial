package com.example.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.DogImage
import com.example.domain.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: DogRepository
): ViewModel() {

    private var _currentDogImage = MutableStateFlow<DogImage?>(null)

    val currentDogImage: StateFlow<DogImage?>
        get() = _currentDogImage

    init {
        getDogImage()
    }

    fun getDogImage() {
        viewModelScope.launch {
            _currentDogImage.emit(repository.fetchDogImage())
        }
    }
}