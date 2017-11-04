package com.example.recipies2.controllers

import com.example.recipies2.services.RecipeService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class RecipeController(
        val recipeService: RecipeService
){
    @RequestMapping("/recipe/show/{id}")
    fun showById(@PathVariable id: String, model: Model): String {
        model.addAttribute("recipe", recipeService.findById(id.toLong()))
        return "recipe/show"
    }
}