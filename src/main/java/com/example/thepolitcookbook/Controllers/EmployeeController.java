package com.example.thepolitcookbook.Controllers;

import com.example.thepolitcookbook.Entities.Recipe;
import com.example.thepolitcookbook.Repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    private List<Recipe> getAllRecipes(){
        return recipeRepository.findAll();
    }
}
