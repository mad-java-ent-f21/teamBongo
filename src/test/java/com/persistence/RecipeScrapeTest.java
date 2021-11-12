package com.persistence;

import junit.framework.TestCase;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.ArrayList;

@Log4j2
public class RecipeScrapeTest {

    @Test
    public void getIngredients() {

        RecipeScrape recipe = new RecipeScrape();

        ArrayList<String> results;

        results = recipe.scrapeIngredients();

        for (String item: results) {
            log.info(item);
        }
    }

}