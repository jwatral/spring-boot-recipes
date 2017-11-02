package com.example.recipies2.controllers

import com.example.recipies2.domain.Recipe
import com.example.recipies2.services.RecipeService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.ui.Model

class IndexControllerTest {
    lateinit var sut: IndexController

    @Mock
    lateinit var recipeService: RecipeService

    @Mock
    lateinit var model: Model

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sut = IndexController(recipeService)
    }

    @Test
    fun testMockMVC() {

        val mockMvc = MockMvcBuilders.standaloneSetup(sut).build()

        mockMvc.perform(get("/"))
                .andExpect(status().isOk)
                .andExpect(view().name("index"))
    }

    @Test
    fun testIndex() {
        // given
        val recipes = hashSetOf(Recipe(), Recipe())

        Mockito.`when`(recipeService.getRecipes()).thenReturn(recipes)

        val recipesCapture = ArgumentCaptor.forClass(Set::class.java)

        // when
        val result = sut.getIndexPage(model)

        // then
        assertEquals("index", result)
        verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"), recipesCapture.capture())
        verify(recipeService, Mockito.times(1)).getRecipes()

        assertEquals(recipes, recipesCapture.value)
        assertEquals(2, recipesCapture.value.size)
    }
}