package com.example.thepolitcookbook.Payloads;

import lombok.Getter;
import lombok.Setter;

public class RecipeUpdatePayload {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String  ingredients;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private String image;

}
