package com.example.thepolitcookbook.Controllers;

import com.example.thepolitcookbook.Entities.Recipe;
import com.example.thepolitcookbook.Exception.ResourceNotFoundException;
import com.example.thepolitcookbook.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    private List<Recipe> getAllRecipes(){
        return recipeService.findAllRecipes();
    }


    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id){

        Recipe recipe = recipeService.find(id);
        return ResponseEntity.ok(recipe);

    }
}
