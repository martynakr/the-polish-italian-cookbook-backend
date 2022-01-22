package com.example.thepolitcookbook.Entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @NotNull
    @Column(name = "name")
    private String name;

    @Getter @Setter
    @Column(name = "ingredients")
    private String ingredients;

    @Getter @Setter
    @Column(name = "description")
    private String description;

    @Getter @Setter
    @Column(name = "portions")
    private long portions;

    @Getter @Setter
    @Column(name = "image")
    private String image;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "recipe_creator_id", referencedColumnName = "id")
    private RecipeCreator recipeCreator;

    public Recipe(){};

    public Recipe(String name, String ingredients, String description, long portions, Country country, RecipeCreator recipeCreator) {
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.portions = portions;
        this.country = country;
        this.recipeCreator = recipeCreator;
    }

}
