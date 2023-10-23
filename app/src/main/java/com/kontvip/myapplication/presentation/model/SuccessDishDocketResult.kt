package com.kontvip.myapplication.presentation.model

import com.kontvip.myapplication.domain.model.DishDocketState

interface UiState : DishDocketState {


    data class Recipes(private val recipes: List<Recipe>
    ) : ArrayList<Recipes.Recipe>(recipes), UiState {

        constructor(vararg recipes: Recipe) : this(recipes.asList())

        data class Recipe(
            private val mealName: String,
            private val area: String,
            private val category: String,
            private val instructions: String,
            private val ingredientsAndMeasures: Map<String, String>,
            private val imageUrl: String,
            private val sourceUrl: String,
            private val youtubeUrl: String
        )
    }

    data class Meals(
        private val meals: List<Meal>
    ) : ArrayList<Meals.Meal>(meals), UiState {

        constructor(vararg meals: Meal) : this(meals.asList())
        data class Meal(
            private val mealId: String,
            private val mealName: String,
            private val imageUrl: String
        )

    }

    class NoInternet() : UiState {
    }

    class NoPermissions() : UiState {
    }

    class ServiceUnavailable() : UiState {
    }
}