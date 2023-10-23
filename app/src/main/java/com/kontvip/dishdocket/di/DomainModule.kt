package com.kontvip.dishdocket.di

import com.kontvip.dishdocket.domain.DishDocketInteractor
import com.kontvip.dishdocket.domain.core.Repository
import com.kontvip.dishdocket.domain.core.StateExceptionFactory
import com.kontvip.dishdocket.domain.model.DishDocketState
import com.kontvip.dishdocket.domain.model.DomainMealList
import com.kontvip.dishdocket.domain.model.DomainRecipeList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideDishDocketInteractor(
        repository: Repository,
        domainMealMapper: DomainMealList.Mapper<DishDocketState>,
        domainRecipeMapper: DomainRecipeList.Mapper<DishDocketState>,
        stateExceptionFactory: StateExceptionFactory
    ): DishDocketInteractor = DishDocketInteractor.Default(
        repository = repository,
        domainMealMapper = domainMealMapper,
        domainRecipeMapper = domainRecipeMapper,
        stateExceptionFactory = stateExceptionFactory
    )
}