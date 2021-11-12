package com.persistence;

import junit.framework.TestCase;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

@Log4j2
public class RecipeScrapeTest {

    @Test
    public void getHTML() {

        RecipeScrape recipe = new RecipeScrape();

        String results = recipe.scrapeRecipe();

        log.info(results);
    }

}