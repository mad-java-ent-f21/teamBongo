package com.persistence;

import com.entity.categories.Categories;
import com.entity.categories.Category;
import com.entity.recipe.Recipe;
import junit.framework.TestCase;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

@Log4j2
public class RecipeScrapeTest {


    @Test
    public void scrapeRecipe() {
        RecipeScrape recipeScrape = new RecipeScrape();

        Recipe recipe = new Recipe();

        recipe = recipeScrape.scrapeRecipe("https://damndelicious.net/2021/10/21/pumpkin-donut-holes/");

        assertEquals("Pumpkin Donut Holes", recipe.getName());

        //log.info(recipe);
    }

    @Test
    public void scrapeStepsTest() {

        RecipeScrape recipe = new RecipeScrape();

        ArrayList<String> results;

        results = recipe.scrapeSteps("https://damndelicious.net/2021/10/16/thai-coconut-curry-ramen/print/");

        for (String item: results) {
            log.info(item);
        }
    }


    @Test
    public void scrapeIngredientsTest() {

        RecipeScrape recipe = new RecipeScrape();

        ArrayList<String> results;

        results = recipe.scrapeIngredients("https://damndelicious.net/2021/10/16/thai-coconut-curry-ramen/print/");

        for (String item: results) {
            log.info(item);
        }
    }

    @Test
    public void scrapeAllCategoriesTest() {
        RecipeScrape categories = new RecipeScrape();

        ArrayList<Category> results;

        results = categories.scrapeAllCategories();

        for (Category item : results) {
            log.info(item);
        }

    }

    @Test
    public void scrapeByCategoryName() {
        RecipeScrape scraper = new RecipeScrape();

        Category results;

        results = scraper.scrapeByCategoryName("https://damndelicious.net/category/christmas/", 10);

        for (Recipe item : results.getRecipes()) {
            log.info(item);
        }
    }
}