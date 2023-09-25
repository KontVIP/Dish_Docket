package com.kontvip.myapplication.domain

import com.kontvip.myapplication.domain.model.DomainMeal
import com.kontvip.myapplication.domain.model.DomainRecipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

abstract class Interactor {

    protected suspend fun <T> invoke(block: suspend () -> T): Flow<T> = try {
        flowOf(block.invoke())
    } catch (e: Exception) {
        emptyFlow()
    }
}

interface DishDocketInteractor<M, R> {
    suspend fun mealsByName(name: String): Flow<List<M>>
    suspend fun mealsByCountry(country: String): Flow<List<M>>
    suspend fun mealsByIngredient(ingredient: String): Flow<List<M>>
    suspend fun recipeById(id: String): Flow<R>
    suspend fun randomRecipe(): Flow<R>
}

class DefaultDishDocketInteractor<M, R>(
    private val repository: Repository,
    private val domainMealMapper: DomainMeal.Mapper<M>,
    private val domainRecipeMapper: DomainRecipe.Mapper<R>
) : Interactor(), DishDocketInteractor<M, R> {

    override suspend fun mealsByName(name: String): Flow<List<M>> = invoke {
        repository.mealsByName(name).map { it.map(domainMealMapper) }
    }

    override suspend fun mealsByCountry(country: String): Flow<List<M>> = invoke {
        repository.mealsByCountry(country).map { it.map(domainMealMapper) }
    }

    override suspend fun mealsByIngredient(ingredient: String): Flow<List<M>> = invoke {
        repository.mealsByIngredient(ingredient).map { it.map(domainMealMapper) }
    }

    override suspend fun recipeById(id: String): Flow<R> = invoke {
        repository.recipeById(id).first().map(domainRecipeMapper)
    }

    override suspend fun randomRecipe(): Flow<R> = invoke {
        repository.randomRecipe().first().map(domainRecipeMapper)
    }
}