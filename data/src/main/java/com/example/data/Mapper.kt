package com.example.data

import com.example.domain.DogImage

fun DogImageDTO.toDogImage(): DogImage {
    return DogImage(this.message)
}