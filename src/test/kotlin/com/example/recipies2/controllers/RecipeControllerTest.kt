package com.example.recipies2.controllers

import com.example.recipies2.domain.Recipe
import com.example.recipies2.services.RecipeService
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class RecipeControllerTest {
    @Mock
    lateinit var recipeService: RecipeService

    lateinit var recipeController: RecipeController

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        recipeController = RecipeController(recipeService)
    }

    @Test
    fun testGetRecipe() {
        val recipe = Recipe(id = 1L)

        val mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build()

        Mockito.`when`(recipeService.findById(anyLong())).thenReturn(recipe)

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk)
                .andExpect(view().name("recipe/show"))
    }
}