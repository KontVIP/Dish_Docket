package com.kontvip.myapplication.domain

import com.kontvip.myapplication.domain.core.Repository
import com.kontvip.myapplication.domain.core.StateExceptionFactory
import com.kontvip.myapplication.domain.model.DishDocketState
import com.kontvip.myapplication.domain.model.DomainMealList
import com.kontvip.myapplication.domain.model.DomainRecipeList
import kotlinx.coroutines.flow.Flow

interface DishDocketInteractor {
    suspend fun mealsByName(name: String): Flow<DishDocketState>
    suspend fun mealsByCountry(country: String): Flow<DishDocketState>
    suspend fun mealsByIngredient(ingredient: String): Flow<DishDocketState>
    suspend fun recipeById(id: String): Flow<DishDocketState>
    suspend fun randomRecipe(): Flow<DishDocketState>

    class Default(
        private val repository: Repository,
        private val domainMealMapper: DomainMealList.Mapper<DishDocketState>,
        private val domainRecipeMapper: DomainRecipeList.Mapper<DishDocketState>,
        stateExceptionFactory: StateExceptionFactory
    ) : Interactor(stateExceptionFactory), DishDocketInteractor {

        override suspend fun mealsByName(name: String): Flow<DishDocketState> = invoke {
            repository.mealsByName(name).map(domainMealMapper)
        }

        override suspend fun mealsByCountry(country: String): Flow<DishDocketState> = invoke {
            repository.mealsByCountry(country).map(domainMealMapper)
        }

        override suspend fun mealsByIngredient(ingredient: String): Flow<DishDocketState> = invoke {
            repository.mealsByIngredient(ingredient).map(domainMealMapper)
        }

        override suspend fun recipeById(id: String): Flow<DishDocketState> = invoke {
            repository.recipeById(id).map(domainRecipeMapper)
        }

        override suspend fun randomRecipe(): Flow<DishDocketState> = invoke {
            repository.randomRecipe().map(domainRecipeMapper)
        }
    }
}