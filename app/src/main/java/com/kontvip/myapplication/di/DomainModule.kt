package com.kontvip.myapplication.di

import com.kontvip.myapplication.domain.DishDocketInteractor
import com.kontvip.myapplication.domain.core.Repository
import com.kontvip.myapplication.domain.core.StateExceptionFactory
import com.kontvip.myapplication.domain.model.DishDocketState
import com.kontvip.myapplication.domain.model.DomainMealList
import com.kontvip.myapplication.domain.model.DomainRecipeList
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