package com.kontvip.dishdocket.presentation.model

import com.kontvip.dishdocket.databinding.ActivityMainBinding
import com.kontvip.dishdocket.domain.model.DishDocketState

interface UiState : DishDocketState {


    data class Recipes(private val recipes: List<UiRecipe>
    ) : ArrayList<UiRecipe>(recipes), UiState {

        constructor(vararg recipes: UiRecipe) : this(recipes.asList())
    }

    data class Meals(
        private val meals: List<UiMeal>
    ) : ArrayList<UiMeal>(meals), UiState {

        constructor(vararg meals: UiMeal) : this(meals.asList())

        fun applyUi(binding: ActivityMainBinding) {

        }
    }

    class NoInternet() : UiState {
    }

    class NoPermissions() : UiState {
    }

    class ServiceUnavailable() : UiState {
    }
}