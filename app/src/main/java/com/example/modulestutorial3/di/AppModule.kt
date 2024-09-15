package com.example.modulestutorial3.di

import com.example.common.util.Const
import com.example.data.DogApi
import com.example.data.DogRepositoryImpl
import com.example.domain.DogRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindDogRepository(impl: com.example.data.DogRepositoryImpl): DogRepository

    companion object {
        @Singleton
        @Provides
        fun provideDogApi(): com.example.data.DogApi = Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(com.example.data.DogApi::class.java)
    }
}