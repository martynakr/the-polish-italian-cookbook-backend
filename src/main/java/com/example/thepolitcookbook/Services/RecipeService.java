package com.example.thepolitcookbook.Services;

import com.example.thepolitcookbook.Entities.Recipe;
import com.example.thepolitcookbook.Exception.ResourceNotFoundException;
import com.example.thepolitcookbook.Repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> findAllRecipes(){
        return recipeRepository.findAll();
    }

    public Recipe find(Long id){

        Optional<Recipe> recipe = recipeRepository.findById(id);

        if(recipe.isEmpty()) {
            throw new ResourceNotFoundException("Recipe doesn't exist, id:" + id);
        }

        return recipe.get();
    }


}
