package com.entity.recipe;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Steps {

    @JsonProperty("steps_items")
    private List<String> stepsItems;

    //STEPS_ITEMS: GET and SET
    public void setStepsItems(List<String> stepsItems) { this.stepsItems = stepsItems; }

    public List<String> getStepsItems() { return this.stepsItems; }
}
