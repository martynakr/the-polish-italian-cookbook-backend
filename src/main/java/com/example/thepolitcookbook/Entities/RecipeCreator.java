package com.example.thepolitcookbook.Entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="recipe_creators")
public class RecipeCreator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Getter @Setter
    @NotNull
    @Column(name = "recipe_creator_name")
    private String recipe_creator_name;

    public RecipeCreator(){};

    public RecipeCreator(String recipe_creator_name) {
        this.recipe_creator_name = recipe_creator_name;
    }
}

