package com.example.recipies2.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
class Ingredient(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        var description: String,
        var amount: BigDecimal,
        @ManyToOne
        var recipe: Recipe? = null,
        @OneToOne
        var uom: UnitOfMeasure
)