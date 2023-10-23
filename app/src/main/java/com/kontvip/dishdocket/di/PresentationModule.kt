package com.kontvip.dishdocket.di

import com.kontvip.dishdocket.domain.model.DomainMealList
import com.kontvip.dishdocket.domain.model.DomainRecipeList
import com.kontvip.dishdocket.presentation.UiStateExceptionFactory
import com.kontvip.dishdocket.presentation.mapper.DomainMealListToUiStateMapper
import com.kontvip.dishdocket.presentation.mapper.DomainRecipeListToUiStateMapper
import com.kontvip.dishdocket.presentation.model.UiState
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