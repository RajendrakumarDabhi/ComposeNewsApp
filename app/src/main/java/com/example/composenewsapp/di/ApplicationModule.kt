package com.example.composenewsapp.di

import android.app.Application
import android.content.Context
import com.example.composenewsapp.data.remote.api.NewsApi
import com.example.composenewsapp.data.repositories.LocalPreferenceRepositoryImpl
import com.example.composenewsapp.data.repositories.NewsRepositoryImpl
import com.example.composenewsapp.domain.repositories.LocalPreferenceRepository
import com.example.composenewsapp.domain.repositories.NewsRepository
import com.example.composenewsapp.domain.usecases.appentry.AppEntryUseCases
import com.example.composenewsapp.domain.usecases.appentry.ReadAppEntryUseCase
import com.example.composenewsapp.domain.usecases.appentry.WriteAppEntryUseCase
import com.example.composenewsapp.domain.usecases.news.GetNewsUseCase
import com.example.composenewsapp.domain.usecases.news.NewsUseCases
import com.example.composenewsapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(client: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository): NewsUseCases {
        return NewsUseCases(
            getNewsUseCase = GetNewsUseCase(newsRepository),
        )
    }
}