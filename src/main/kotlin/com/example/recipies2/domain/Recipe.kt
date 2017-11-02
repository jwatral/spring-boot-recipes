package com.example.recipies2.domain

import javax.persistence.*

@Entity
class Recipe(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        var description: String = "",
        var prepTime: Int = 0,
        var cookTime: Int = 0,
        var servings: Int = 0,
        var source: String = "",
        var url: String = "",
        @Lob
        var directions: String = "",
        @Lob
        var image: ByteArray = byteArrayOf(),
        @Enumerated(value = EnumType.STRING)
        var difficulty: Difficulty = Difficulty.EASY,
        notes: Notes? = null,
        @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "recipe")
        var ingredients: Set<Ingredient> = hashSetOf(),
        @ManyToMany
        @JoinTable(name = "recipe_category",
                joinColumns = arrayOf(JoinColumn(name = "recipe_id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "category_id")))
        var categories: Set<Category> = hashSetOf()
) {
        @OneToOne(cascade = arrayOf(CascadeType.ALL))
        var notes = notes
        set(value) {
                field = value
                field?.recipe = this
        }
}