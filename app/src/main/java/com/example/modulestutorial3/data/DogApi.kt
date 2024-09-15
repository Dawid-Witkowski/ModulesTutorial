package com.example.modulestutorial3.data

import retrofit2.http.GET

interface DogApi {

    @GET("breeds/image/random")
    suspend fun fetchDogImage(): DogImageDTO

}