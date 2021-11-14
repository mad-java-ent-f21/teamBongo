package com.entity.recipe;

import java.lang.reflect.Array;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Recipe {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private String category;

    @JsonProperty("yield")
    private String yield;

    @JsonProperty("prep_time")
    private String prepTime;

    @JsonProperty("cook_time")
    private String cookTime;

    @JsonProperty("ingredients")
    private Ingredients ingredients;

    @JsonProperty("steps")
    private Steps steps;

    //ID: GET and SET
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    //NAME: GET and SET
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //CATEGORY: GET and SET
    public void setCategory(String category) { this.category = category; }

    public String getCategory() { return this.category; }

    //SERVING SIZE: GET and SET
    public void setYield(String servingSize) {
        this.yield = servingSize;
    }

    public String getYield() {
        return this.yield;
    }

    //PREP_TIME: GET and SET
    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getPrepTime() {
        return this.prepTime;
    }

    //COOK_TIME: GET and SET
    public void setCookTime(String cookTime) { this.cookTime = cookTime; }

    public String getCookTime() { return cookTime; }

    //INGREDIENTS: GET and SET
    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredients getIngredients() {
        return this.ingredients;
    }

    //STEPS: GET and SET
    public void setSteps(Steps steps) {
        this.steps = steps;
    }

    public Steps getSteps() {
        return this.steps;
    }

    @Override
    public String toString() {
        return
                "Recipe{" +
                        "id = '" + id + '\'' +
                        " ,name = '" + name + '\'' +
                        " ,category = '" + category + '\'' +
                        " ,yield = '" + yield + '\'' +
                        " ,prep_time = '" + prepTime + '\'' +
                        " ,cook_time = '" + cookTime + '\'' +
                        " ,ingredients = '" + ingredients.getIngredientItems() + '\'' +
                        " ,steps = '" + steps.getStepsItems() + '\'' +
                        "}";
    }
}
