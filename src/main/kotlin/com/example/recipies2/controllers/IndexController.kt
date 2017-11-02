package com.example.recipies2.controllers

import com.example.recipies2.repositories.CategoryRepository
import com.example.recipies2.repositories.UnitOfMeasureRepository
import com.example.recipies2.services.RecipeService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController(
        var recipeService: RecipeService
) {
    @RequestMapping("", "/", "index")
    fun getIndexPage(model: Model): String {
        model.addAttribute("recipes", recipeService.getRecipes())
        return "index"
    }
}