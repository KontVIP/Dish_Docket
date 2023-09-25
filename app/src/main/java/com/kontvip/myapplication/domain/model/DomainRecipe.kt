package com.kontvip.myapplication.domain.model

data class DomainRecipe(
    private val mealName: String,
    private val area: String,
    private val category: String,
    private val instructions: String,
    private val ingredientsAndMeasures: Map<String, String>,
    private val imageUrl: String,
    private val sourceUrl: String,
    private val youtubeUrl: String,
)