package com.kontvip.dishdocket.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kontvip.dishdocket.core.AppDispatchers
import com.kontvip.dishdocket.data.DataToDomainFacade
import com.kontvip.dishdocket.data.DefaultRepository
import com.kontvip.dishdocket.data.cache.CacheSource
import com.kontvip.dishdocket.data.cache.database.DishDocketDao
import com.kontvip.dishdocket.data.cache.database.DishDocketDatabase
import com.kontvip.dishdocket.data.cache.model.meal.CacheMeal
import com.kontvip.dishdocket.data.cache.model.recipe.CacheRecipe
import com.kontvip.dishdocket.data.cloud.CloudSource
import com.kontvip.dishdocket.data.cloud.api.FoodRecipeApi
import com.kontvip.dishdocket.data.cloud.model.meal.CloudMealList
import com.kontvip.dishdocket.data.cloud.model.recipe.CloudRecipe
import com.kontvip.dishdocket.data.cloud.model.recipe.CloudRecipeList
import com.kontvip.dishdocket.data.cloud.parser.CloudRecipeDeserializer
import com.kontvip.dishdocket.data.cache.mapper.CacheMealToDomainMapper
import com.kontvip.dishdocket.data.cache.mapper.CacheRecipeToDomainMapper
import com.kontvip.dishdocket.data.cloud.mapper.CloudMealListToCacheMapper
import com.kontvip.dishdocket.data.cloud.mapper.CloudMealToCacheMapper
import com.kontvip.dishdocket.data.cloud.mapper.CloudRecipeListToCacheMapper
import com.kontvip.dishdocket.data.cloud.mapper.CloudRecipeToCacheMapper
import com.kontvip.dishdocket.data.cloud.model.meal.CloudMeal
import com.kontvip.dishdocket.domain.core.Repository
import com.kontvip.dishdocket.domain.model.DomainMeal
import com.kontvip.dishdocket.domain.model.DomainRecipe
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
        .registerTypeAdapter(CloudRecipe::class.java, CloudRecipeDeserializer())
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
    fun provideRepository(
        cloudSource: CloudSource,
        cacheSource: CacheSource,
        dataToDomainFacade: DataToDomainFacade
    ): Repository = DefaultRepository(
        cloudSource = cloudSource,
        cacheSource = cacheSource,
        dataToDomainFacade = dataToDomainFacade
    )

    @Provides
    @Singleton
    fun provideCacheSource(dao: DishDocketDao): CacheSource = CacheSource.Default(dao = dao)

    @Provides
    @Singleton
    fun provideDishDocketDao(@ApplicationContext context: Context): DishDocketDao =
        Room.databaseBuilder(context, DishDocketDatabase::class.java, "dish_docket_database")
            .fallbackToDestructiveMigration()
            .build().dishDocketDao()

    @Provides
    @Singleton
    fun provideDataToDomainFacade(
        cloudMealListToCacheMapper: CloudMealList.Mapper<List<CacheMeal>>,
        cloudRecipeListToCacheMapper: CloudRecipeList.Mapper<List<CacheRecipe>>,
        cacheMealToDomainMapper: CacheMeal.Mapper<DomainMeal>,
        cacheRecipeToDomainMapper: CacheRecipe.Mapper<DomainRecipe>,
    ): DataToDomainFacade = DataToDomainFacade.Default(
        cloudMealListToCacheMapper = cloudMealListToCacheMapper,
        cloudRecipeListToCacheMapper = cloudRecipeListToCacheMapper,
        cacheMealToDomainMapper = cacheMealToDomainMapper,
        cacheRecipeToDomainMapper = cacheRecipeToDomainMapper
    )

    @Provides
    @Singleton
    fun provideCacheRecipeToDomainMapper(): CacheRecipe.Mapper<DomainRecipe> =
        CacheRecipeToDomainMapper()

    @Provides
    @Singleton
    fun provideCacheMealToDomainMapper(): CacheMeal.Mapper<DomainMeal> =
        CacheMealToDomainMapper()

    @Provides
    @Singleton
    fun provideCloudRecipeToCacheMapper(): CloudRecipe.Mapper<CacheRecipe> =
        CloudRecipeToCacheMapper()

    @Provides
    @Singleton
    fun provideCloudMealListToCacheMapper(
        cloudMealToCacheMapper: CloudMeal.Mapper<CacheMeal>
    ): CloudMealList.Mapper<List<CacheMeal>> = CloudMealListToCacheMapper(
        cloudMealToCacheMapper = cloudMealToCacheMapper
    )

    @Provides
    @Singleton
    fun provideCloudMealToCacheMapper(): CloudMeal.Mapper<CacheMeal> =
        CloudMealToCacheMapper()

    @Provides
    @Singleton
    fun provideCloudRecipeListToCacheMapper(
        cloudRecipeToCacheMapper: CloudRecipe.Mapper<CacheRecipe>
    ): CloudRecipeList.Mapper<List<CacheRecipe>> = CloudRecipeListToCacheMapper(
        cloudRecipeToCacheMapper = cloudRecipeToCacheMapper
    )
}