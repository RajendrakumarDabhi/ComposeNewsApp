package com.example.composenewsapp.di

import android.app.Application
import android.content.Context
import com.example.composenewsapp.data.repositories.LocalPreferenceRepositoryImpl
import com.example.composenewsapp.domain.repositories.LocalPreferenceRepository
import com.example.composenewsapp.domain.usecases.AppEntryUseCases
import com.example.composenewsapp.domain.usecases.ReadAppEntryUseCase
import com.example.composenewsapp.domain.usecases.WriteAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideLocalPreferenceRepository(context: Application): LocalPreferenceRepository {
        return LocalPreferenceRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localPreferenceRepository: LocalPreferenceRepository): AppEntryUseCases {
        return AppEntryUseCases(
            ReadAppEntryUseCase = ReadAppEntryUseCase(localPreferenceRepository),
            WriteAppEntryUseCase = WriteAppEntryUseCase(localPreferenceRepository)
        )
    }
}