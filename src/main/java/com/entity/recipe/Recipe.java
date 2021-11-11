package com.entity.recipe;

import java.lang.reflect.Array;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Recipe {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("serving_size")
    private String servingSize;

    @JsonProperty("time")
    private Double time;

    @JsonProperty("ingredients")
    private List<String> ingredients;

    @JsonProperty("steps")
    private List<String> steps;

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

    //SERVING SIZE: GET and SET
    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public String getServingSize() {
        return this.servingSize;
    }

    //TIME: GET and SET
    public void setTime(Double time) {
        this.time = time;
    }

    public Double getTime() {
        return this.time;
    }

    //INGREDIENTS: GET and SET
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    //STEPS: GET and SET
    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public List<String> getSteps() {
        return this.steps;
    }

    @Override
    public String toString() {
        return
                "Recipe{" +
                        "id = '" + id + '\'' +
                        ",name = '" + name + '\'' +
                        ",serving_size = '" + servingSize + '\'' +
                        ",time = '" + time + '\'' +
                        ",ingredients = '" + ingredients + '\'' +
                        ",steps = '" + steps + '\'' +
                        "}";
    }
}
