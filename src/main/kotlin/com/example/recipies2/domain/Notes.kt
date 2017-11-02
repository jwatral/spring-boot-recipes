package com.example.recipies2.domain

import javax.persistence.*

@Entity
class Notes (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        @OneToOne
        var recipe: Recipe? = null,
        @Lob
        var notes: String = ""
) {
}