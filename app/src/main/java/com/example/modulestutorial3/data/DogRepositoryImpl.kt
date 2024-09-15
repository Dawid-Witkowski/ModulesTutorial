package com.example.modulestutorial3.data

import com.example.domain.DogImage
import com.example.domain.DogRepository
import javax.inject.Inject


class DogRepositoryImpl @Inject constructor(
    private val api: DogApi
): DogRepository {
    override suspend fun fetchDogImage(): DogImage { return api.fetchDogImage().toDogImage() }
}