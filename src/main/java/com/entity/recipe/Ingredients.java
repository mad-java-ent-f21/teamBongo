package com.entity.recipe;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ingredients {

    @JsonProperty("ingredient_items")
    private List<String> ingredientItems;

    //INGREDIENT_ITEMS: GET and SET
    public void setIngredientItems(List<String> ingredientItems) { this.ingredientItems = ingredientItems; }

    public List<String> getIngredientItems() {
        return this.ingredientItems;
    }
}
