package com.kontvip.myapplication.domain

import com.kontvip.myapplication.domain.mapper.ExceptionFactory
import com.kontvip.myapplication.domain.model.DishDocketResult
import com.kontvip.myapplication.domain.model.DomainMealList
import com.kontvip.myapplication.domain.model.DomainRecipeList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

abstract class Interactor(private val exceptionFactory: ExceptionFactory) {

    protected suspend fun invoke(block: suspend () -> DishDocketResult): Flow<DishDocketResult> =
        try {
            flowOf(block.invoke())
        } catch (e: Exception) {
            flowOf(exceptionFactory.build(e))
        }
}

interface DishDocketInteractor {
    suspend fun mealsByName(name: String): Flow<DishDocketResult>
    suspend fun mealsByCountry(country: String): Flow<DishDocketResult>
    suspend fun mealsByIngredient(ingredient: String): Flow<DishDocketResult>
    suspend fun recipeById(id: String): Flow<DishDocketResult>
    suspend fun randomRecipe(): Flow<DishDocketResult>
}

class DefaultDishDocketInteractor(
    private val repository: Repository,
    private val domainMealMapper: DomainMealList.Mapper<DishDocketResult>,
    private val domainRecipeMapper: DomainRecipeList.Mapper<DishDocketResult>,
    exceptionFactory: ExceptionFactory
) : Interactor(exceptionFactory), DishDocketInteractor {

    override suspend fun mealsByName(name: String): Flow<DishDocketResult> = invoke {
        repository.mealsByName(name).map(domainMealMapper)
    }

    override suspend fun mealsByCountry(country: String): Flow<DishDocketResult> = invoke {
        repository.mealsByCountry(country).map(domainMealMapper)
    }

    override suspend fun mealsByIngredient(ingredient: String): Flow<DishDocketResult> = invoke {
        repository.mealsByIngredient(ingredient).map(domainMealMapper)
    }

    override suspend fun recipeById(id: String): Flow<DishDocketResult> = invoke {
        repository.recipeById(id).map(domainRecipeMapper)
    }

    override suspend fun randomRecipe(): Flow<DishDocketResult> = invoke {
        repository.randomRecipe().map(domainRecipeMapper)
    }
}