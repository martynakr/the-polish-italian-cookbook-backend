package com.example.thepolitcookbook.Payloads;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RecipeCreatePayload {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter @Setter
    private long countryId;

    @Getter @Setter
    private long recipeCreatorId;

    @Getter @Setter @NonNull
    private String name;

    @Getter @Setter
    private String image;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private String ingredients;

    @Getter @Setter
    private long portions;

}
