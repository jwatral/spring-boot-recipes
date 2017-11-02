package com.example.recipies2

import com.example.recipies2.domain.Recipe
import com.example.recipies2.repositories.RecipeRepository
import com.example.recipies2.services.RecipeService
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RecipeServiceImplTest {
    lateinit var service: RecipeService

    @Mock
    lateinit var recipeRepository: RecipeRepository

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)
        service = RecipeServiceImpl(recipeRepository)
    }

    @Test
    fun getRecipes() {
        val recipe = Recipe()

        Mockito.`when`(recipeRepository.findAll()).thenReturn(hashSetOf(recipe))
        val recipes = service.getRecipes()

        assertEquals(1, recipes.size)
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll()
    }

}