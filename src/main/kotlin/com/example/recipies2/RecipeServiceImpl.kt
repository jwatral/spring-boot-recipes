package com.example.recipies2

import com.example.recipies2.repositories.RecipeRepository
import com.example.recipies2.services.RecipeService
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl(
        val recipeRepository: RecipeRepository
) : RecipeService {
    override fun findById(id: Long) = recipeRepository.findById(id).orElseThrow({ RuntimeException() })

    override fun getRecipes() = recipeRepository.findAll().toHashSet()
}