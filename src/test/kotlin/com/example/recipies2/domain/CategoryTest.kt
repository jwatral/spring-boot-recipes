package com.example.recipies2.domain

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class CategoryTest {

    lateinit var category: Category

    @Before
    fun setUp() {
        category = Category()
    }

    @Test
    fun getId() {
        val idValue = 10L

        category.id = idValue

        assertEquals(idValue, category.id)
    }

    @Test
    fun getDescription() {
    }

    @Test
    fun getRecipes() {
    }

}