package com.example.thepolitcookbook.Services;

import com.example.thepolitcookbook.Entities.Country;
import com.example.thepolitcookbook.Entities.Recipe;
import com.example.thepolitcookbook.Entities.RecipeCreator;
import com.example.thepolitcookbook.Exception.AlreadyExistsError;
import com.example.thepolitcookbook.Exception.ResourceNotFoundException;
import com.example.thepolitcookbook.Payloads.RecipeCreatePayload;
import com.example.thepolitcookbook.Payloads.RecipeUpdatePayload;
import com.example.thepolitcookbook.Repositories.CountryRepository;
import com.example.thepolitcookbook.Repositories.RecipeCreatorRepository;
import com.example.thepolitcookbook.Repositories.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeService {

    protected final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RecipeCreatorRepository recipeCreatorRepository;

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

    public Optional<List<Recipe>> findByQuery(String query){
        return recipeRepository.getQueryMatch(query);
    }

    public Recipe create(RecipeCreatePayload recipeCreatePayload) {

        Recipe newRecipe = new Recipe();

        Optional<Country> country = countryRepository.findById(recipeCreatePayload.getCountryId());
        Optional<RecipeCreator> recipeCreator = recipeCreatorRepository.findById(recipeCreatePayload.getRecipeCreatorId());


        if(recipeRepository.existsByName(recipeCreatePayload.getName())){
            throw new AlreadyExistsError(String.format("Recipe with name: %s already exists", recipeCreatePayload.getName()));
        }
        modelMapper.map(recipeCreatePayload, newRecipe);

        newRecipe.setName(recipeCreatePayload.getName());
        newRecipe.setDescription(recipeCreatePayload.getDescription());
        newRecipe.setIngredients(recipeCreatePayload.getIngredients());
        newRecipe.setPortions(recipeCreatePayload.getPortions());
        newRecipe.setImage(recipeCreatePayload.getImage());
        newRecipe.setCountry(country.get());
        newRecipe.setRecipeCreator(recipeCreator.get());

        return recipeRepository.save(newRecipe);
    }

    public void delete(Long id){
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recipe doesn't exist, id: " + id));
        recipeRepository.delete(recipe);
    }

    public Recipe update(Long id, RecipeUpdatePayload recipeUpdatePayload){

        var recipe = recipeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recipe doesn't exist, id:" + id));

        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(recipeUpdatePayload, recipe);

        return recipeRepository.save(recipe);
    }
}
