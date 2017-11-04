package com.example.recipies2

import com.example.recipies2.domain.Recipe
import com.example.recipies2.repositories.RecipeRepository
import com.example.recipies2.services.RecipeService
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations
import java.util.*

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
    fun getRecipesTest() {
        val recipe = Recipe()

        Mockito.`when`(recipeRepository.findAll()).thenReturn(hashSetOf(recipe))
        val recipes = service.getRecipes()

        assertEquals(1, recipes.size)
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll()
    }

    @Test
    fun getRecipeByIdTest() {

        val recipe = Recipe(id = 1L)

        Mockito.`when`(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe))

        val recipeReturned = service.findById(1L)

        assertNotNull(recipeReturned)
        Mockito.verify(recipeRepository, times(1)).findById(anyLong())
        Mockito.verify(recipeRepository, never()).findAll()
    }
}