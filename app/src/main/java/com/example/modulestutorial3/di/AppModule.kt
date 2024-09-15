package com.example.modulestutorial3.di

import com.example.common.util.Const
import com.example.domain.DogRepository
import com.example.modulestutorial3.data.DogApi
import com.example.modulestutorial3.data.DogRepositoryImpl
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
    abstract fun bindDogRepository(impl: DogRepositoryImpl): DogRepository

    companion object {
        @Singleton
        @Provides
        fun provideDogApi(): DogApi = Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApi::class.java)
    }
}