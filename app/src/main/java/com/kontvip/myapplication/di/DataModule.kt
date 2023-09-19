package com.kontvip.myapplication.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kontvip.myapplication.core.AppDispatchers
import com.kontvip.myapplication.data.DefaultRepository
import com.kontvip.myapplication.data.cloud.CloudSource
import com.kontvip.myapplication.data.cloud.api.FoodRecipeApi
import com.kontvip.myapplication.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideFoodRecipeApi(retrofit: Retrofit): FoodRecipeApi =
        retrofit.create(FoodRecipeApi::class.java)

    @Provides
    @Singleton
    fun provideCloudSource(
        api: FoodRecipeApi,
        appDispatchers: AppDispatchers
    ): CloudSource = CloudSource.Default(
        api = api,
        appDispatchers = appDispatchers
    )

    @Provides
    @Singleton
    fun provideAppDispatchers(): AppDispatchers = AppDispatchers.Default()

    @Provides
    @Singleton
    fun provideRepository(cloudSource: CloudSource): Repository =
        DefaultRepository(cloudSource = cloudSource)
}