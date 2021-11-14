package com.persistence;

import com.entity.categories.Categories;
import com.entity.categories.Category;
import com.entity.recipe.Recipe;
import junit.framework.TestCase;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.ArrayList;

@Log4j2
public class RecipeScrapeTest {

    @Test
    public void scrapeTitleCard() {
        RecipeScrape recipeScrape = new RecipeScrape();
        ArrayList<String> titleList = new ArrayList<>();

        titleList = recipeScrape.titleScrape();

        for (String item : titleList) {
            log.info(item);
        }
    }

    @Test
    public void getIngredients() {

        RecipeScrape recipe = new RecipeScrape();

        ArrayList<String> results;

        results = recipe.scrapeIngredients();

        for (String item: results) {
            log.info(item);
        }
    }

    @Test
    public void scrapeAllCategoriesTest() {
        RecipeScrape categories = new RecipeScrape();

        Categories results;

        results = categories.scrapeAllCategories();

        for (Category item : results.getCategoriesItems()) {
            log.info(item);
        }

    }

    @Test
    public void scrapeByCategoryName() {
        RecipeScrape scraper = new RecipeScrape();

        Category results;

        results = scraper.scrapeByCategoryName("asian-inspired");

        for (Recipe item : results.getRecipes()) {
            log.info(item);
        }
    }
}