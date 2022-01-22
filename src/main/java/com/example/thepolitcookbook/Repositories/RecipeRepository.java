package com.example.thepolitcookbook.Repositories;

import com.example.thepolitcookbook.Entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Boolean existsByName(String name);

    @Modifying
    @Query(value ="SELECT a.* FROM recipes a WHERE a.name LIKE %:searchString%", nativeQuery = true)
    Optional<List<Recipe>> getQueryMatch(@Param(value = "searchString") String searchString);

}