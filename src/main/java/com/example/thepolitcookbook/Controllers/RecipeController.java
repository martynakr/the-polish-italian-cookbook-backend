package com.example.thepolitcookbook.Controllers;

import com.example.thepolitcookbook.Entities.Recipe;
import com.example.thepolitcookbook.Payloads.RecipeCreatePayload;
import com.example.thepolitcookbook.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
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

    @GetMapping(value = "/search")
    @ResponseBody
    public Optional<List<Recipe>> getQuery(@RequestParam String query){
        return recipeService.findByQuery(query);
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody RecipeCreatePayload recipeCreatePayload){
        Recipe recipe = recipeService.create(recipeCreatePayload);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/recipes/{id}")
                .buildAndExpand(recipe.getId()).toUri();

        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRecipe(@PathVariable Long id) {

        recipeService.delete(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Recipe deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);

    }
}
