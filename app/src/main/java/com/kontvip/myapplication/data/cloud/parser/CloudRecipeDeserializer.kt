package com.kontvip.myapplication.data.cloud.parser

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.kontvip.myapplication.data.cloud.model.recipe.CloudRecipe
import java.lang.reflect.Type

class CloudRecipeDeserializer : JsonDeserializer<CloudRecipe> {

    companion object {
        private const val INGREDIENT_KEY = "strIngredient"
        private const val MEASURE_KEY = "strMeasure"
    }

    override fun deserialize(
        json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?
    ): CloudRecipe {
        val jsonObject = json?.asJsonObject ?: JsonObject()

        val ingredientsAndMeasures = mutableMapOf<String, String>()

        var index = 1
        while (true) {
            val ingredientKey = "$INGREDIENT_KEY$index"
            val measureKey = "$MEASURE_KEY$index"

            val hasIngredient = jsonObject.has(ingredientKey)
            val hasMeasure = jsonObject.has(ingredientKey)

            if (!hasIngredient && !hasMeasure) {
                break
            }
            if (hasIngredient && hasMeasure) {
                val ingredientValue = jsonObject.getStringSafely(ingredientKey)
                val measureValue = jsonObject.getStringSafely(measureKey)
                if (ingredientValue.isNotEmpty() && measureValue.isNotEmpty()) {
                    ingredientsAndMeasures[ingredientValue] = measureValue
                }
            }
            index++
        }

        return CloudRecipe(
            jsonObject.getStringSafely("dateModified"),
            jsonObject.getStringSafely("idMeal"),
            jsonObject.getStringSafely("strArea"),
            jsonObject.getStringSafely("strCategory"),
            jsonObject.getStringSafely("strCreativeCommonsConfirmed"),
            jsonObject.getStringSafely("strDrinkAlternate"),
            jsonObject.getStringSafely("strImageSource"),
            jsonObject.getStringSafely("strInstructions"),
            jsonObject.getStringSafely("strMeal"),
            jsonObject.getStringSafely("strMealThumb"),
            jsonObject.getStringSafely("strSource"),
            jsonObject.getStringSafely("strTags"),
            jsonObject.getStringSafely("strYoutube"),
            ingredientsAndMeasures
        )
    }

    private fun JsonObject.getStringSafely(memberName: String): String {
        return try {
            get(memberName).asString
        } catch (e: Exception) {
            ""
        }
    }
}