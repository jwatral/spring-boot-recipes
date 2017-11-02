package com.example.recipies2.repositories

import com.example.recipies2.domain.UnitOfMeasure
import org.springframework.data.repository.CrudRepository

interface UnitOfMeasureRepository : CrudRepository<UnitOfMeasure, Long> {
    fun findByDescription(description: String): UnitOfMeasure?
}