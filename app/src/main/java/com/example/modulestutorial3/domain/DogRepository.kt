package com.example.domain

interface DogRepository {
    suspend fun fetchDogImage(): DogImage
}