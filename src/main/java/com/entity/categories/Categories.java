package com.entity.categories;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Categories {

    @JsonProperty("categories_items")
    private List<Category> categoriesItems;

    //CATEGORIES_ITEMS: GET and SET
    public void setCategoriesItems(List<Category> categoriesItems) { this.categoriesItems = categoriesItems; }

    public List<Category> getCategoriesItems() { return this.categoriesItems; }

    @Override
    public String toString() {
        return
                "Categories{" +
                        "categories_items = '" + categoriesItems + '\'' +
                        "}";
    }
}
