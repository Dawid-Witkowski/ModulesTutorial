package com.example.modulestutorial3.data

import com.example.domain.DogImage

fun DogImageDTO.toDogImage(): DogImage {
    return DogImage(this.message)
}