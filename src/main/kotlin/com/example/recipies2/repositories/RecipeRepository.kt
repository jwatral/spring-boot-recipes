package com.example.recipies2.repositories

import com.example.recipies2.domain.Recipe
import org.springframework.data.repository.CrudRepository

interface RecipeRepository : CrudRepository<Recipe, Long>