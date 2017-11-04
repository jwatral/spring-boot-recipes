package com.example.recipies2.services

import com.example.recipies2.domain.Recipe

interface RecipeService {
    fun getRecipes(): Set<Recipe>
    fun findById(id: Long): Recipe
}