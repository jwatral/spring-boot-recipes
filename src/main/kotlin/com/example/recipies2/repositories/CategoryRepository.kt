package com.example.recipies2.repositories

import com.example.recipies2.domain.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Long> {
    fun findByDescription(description: String): Category?
}