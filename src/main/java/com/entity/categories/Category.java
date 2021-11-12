package com.entity.categories;


import java.util.List;
import com.entity.recipe.Recipe;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

    @JsonProperty("name")
    private String name;

    @JsonProperty("recipes")
    private List<Recipe> recipes;

    //NAME: GET and SET
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //RECIPES: GET and SET
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return this.recipes;
    }

    @Override
    public String toString() {
        return
                "Category{" +
                        "name = '" + name + '\'' +
                        ",recipes = '" + recipes + '\'' +
                        "}";
    }
}
