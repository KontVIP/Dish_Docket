package com.kontvip.myapplication.di

import com.kontvip.myapplication.domain.model.DomainMealList
import com.kontvip.myapplication.domain.model.DomainRecipeList
import com.kontvip.myapplication.presentation.UiStateExceptionFactory
import com.kontvip.myapplication.presentation.mapper.DomainMealListToUiStateMapper
import com.kontvip.myapplication.presentation.mapper.DomainRecipeListToUiStateMapper
import com.kontvip.myapplication.presentation.model.UiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class PresentationModule {

    @Provides
    fun provideStateExceptionFactory(): UiStateExceptionFactory = UiStateExceptionFactory()

    @Provides
    fun provideDomainMealListToUiStateMapper(): DomainMealList.Mapper<UiState> =
        DomainMealListToUiStateMapper()

    @Provides
    fun provideDomainRecipeListToUiStateMapper(): DomainRecipeList.Mapper<UiState> =
        DomainRecipeListToUiStateMapper()
}