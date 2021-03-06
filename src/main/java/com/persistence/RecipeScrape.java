package com.persistence;

import com.entity.categories.Categories;
import com.entity.categories.Category;
import com.entity.recipe.Ingredients;
import com.entity.recipe.Steps;
import com.entity.recipe.Recipe;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class RecipeScrape {

    /**
     * checks recipe and scrapes relevant information like title info, ingredients, and directions.
     * If recipe doens't conform and can't be scraped properly, will return a null.
     * @param url url of recipe page
     * @return returns recipe with title info, ingredients, and steps (directions)
     * @return null if recipe doesn't conform, returns null.
     */
    public Recipe scrapeRecipe(String url) {

        ArrayList<String> titleList = new ArrayList();
        ArrayList<String> ingredientsArrayList = new ArrayList<>();
        ArrayList<String> stepsArrayList = new ArrayList<>();
        String name = "";
        String yield = "";
        String prepTime = "";
        String cookTime = "";

        try {
            final Document recipePage = Jsoup.connect(url).get();

            name = recipePage.select("div.recipe-title h2").text();

            for (Element titleItem : recipePage.select("div.post-meta.time p")) {
                    titleList.add(titleItem.select("span").text());
            }
        } catch (Exception ex){
            log.error(ex);
        }

        if (titleList.size() == 4) {

            Recipe recipe = new Recipe();
            Ingredients ingredients = new Ingredients();
            Steps steps = new Steps();

            ingredientsArrayList = this.scrapeIngredients(url);
            ingredients.setIngredientItems(ingredientsArrayList);

            stepsArrayList = this.scrapeSteps(url);
            steps.setStepsItems(stepsArrayList);

            recipe.setName(name);
            recipe.setYield(titleList.get(0));
            recipe.setPrepTime(titleList.get(1));
            recipe.setCookTime(titleList.get(2));
            recipe.setIngredients(ingredients);
            recipe.setSteps(steps);

            return recipe;
        } else {
            return null;
        }
    }
    /**
     * This class scrapes the ingredients and enters them into a list.
     * @param url url of the recipe we are scraping.
     * @return ingredients
     */
    public ArrayList<String> scrapeIngredients(String url) {

        ArrayList<String> ingredientItems = new ArrayList();

        try {
            final Document recipePage = Jsoup.connect(url).get();

            for (Element item : recipePage.select("div.ingredients ul li")) {
                if (item.text().equals("")) {
                    continue;
                }
                else {
                    ingredientItems.add(item.text());
                }
            }
        }
        catch (Exception ex) {
            log.error(ex);
        }

        return ingredientItems;
    }

    /**
     *
     * @param url url of the recipe we are scraping
     * @return returns the steps(directions) the form of an arrayList.
     */
    public ArrayList<String> scrapeSteps(String url) {
        ArrayList<String> stepItems = new ArrayList();

        try {
            final Document recipePage = Jsoup.connect(url).get();

            for (Element item : recipePage.select("div.instructions ol li")) {
                if (item.text().equals("")) {
                    continue;
                }
                else {
                    stepItems.add(item.text());
                }
            }
        }
        catch (Exception ex) {
            log.error(ex);
        }
        return stepItems;
    }

    /**
     * This method scrapes for all categories and all recipes for each category.
     * @return ArrayList of Category objects
     */
    public ArrayList<Category> scrapeAllCategories() {
        String url = "https://damndelicious.net/recipe-index/";

        ArrayList<Category> categoriesList = new ArrayList();

        try {
            final Document categoryIndexPage = Jsoup.connect(url).get();

            for (Element item : categoryIndexPage.select("div.archive-post a")) {
                if (item.text().equals("")) {
                    continue;
                } else {
                    //Gets the name for each category
                    String catergoryName = item.select("h4.title").text();

                    //Gets the URL to each category
                    String urlToEachCategory = item.attr("abs:href");

                    //Calls the method that scrapes the index of the individual Catergories.
                    Category category = scrapeByCategoryName(urlToEachCategory, 1);

                    categoriesList.add(category);
                }
            }
        } catch (Exception ex) {
            log.error(ex);
        }

        return categoriesList;
    }

    /**
     * This method takes in a specific url for a category and the number of pages to scrape, then returns a Category
     * object.
     * @param url url of the recipe page we are scraping.
     * @param numberOfPagesToScrape
     * @return Category Object
     */
    public Category scrapeByCategoryName(String url, int numberOfPagesToScrape) {

        Category category = new Category();
        ArrayList<Recipe> recipeList = new ArrayList<>();
        String categoryName = "";

        if (numberOfPagesToScrape > 100) {
            numberOfPagesToScrape = 100;
        } if (numberOfPagesToScrape < 0) {
            numberOfPagesToScrape = 0;
        }

        //Code block below scapes the title for the category type.
        try {
            categoryName = Jsoup.connect(url).get().select("h1.archivetitle").text();

        } catch (Exception ex) {
            log.error(ex);
        }

        //Code used to scrpe more than one page. counter goes up by one and it'll move on to the next page.
        int counter = 1;
        String baseUrl = url + "/page/";

        while (counter <= numberOfPagesToScrape ) {
            url = baseUrl + counter;

            try {
                final Document categoryPage = Jsoup.connect(url).get();

                for (Element item : categoryPage.select("div.archive-post a")) {
                    if (item.text().equals("")) {
                        continue;
                    } else {
                        //Recipe Name
                        String recipeName = item.select("h4.title").text();

                        //Recipe Link
                        String urlToEachRecipe = item.attr("abs:href");

                        Recipe recipe = scrapeRecipe(urlToEachRecipe);

                        if (recipe == null) {
                            log.info("Recipe Skipped");
                            continue;
                        } else {
                            log.info("Recipe Added -- " + recipe.getName());
                            recipeList.add(recipe);
                        }
                    }
                }
            } catch (Exception ex) {
                log.error(ex);
                counter = 100;
            }
            counter++;
        }

        log.info(categoryName + " - Finished Scraping");
        category.setName(categoryName);
        category.setRecipes(recipeList);
        return category;
    }
}
