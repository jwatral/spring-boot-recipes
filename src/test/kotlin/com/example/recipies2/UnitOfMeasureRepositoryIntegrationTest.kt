package com.example.recipies2

import com.example.recipies2.repositories.UnitOfMeasureRepository
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class UnitOfMeasureRepositoryIntegrationTest {
    @Autowired
    lateinit var sut: UnitOfMeasureRepository

    @Test
    fun findByDescriptionTeaspoon() {

        val uom = sut.findByDescription("Teaspoon")

        assertEquals("Teaspoon", uom?.description)
    }

    @Test
    fun findByDescriptionCup() {

        val uom = sut.findByDescription("Cup")

        assertEquals("Cup", uom?.description)
    }

    @Test
    fun findByDescriptionTablespoon() {

        val uom = sut.findByDescription("Tablespoon")

        assertEquals("Tablespoon", uom?.description)
    }
}