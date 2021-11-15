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

@Log4j2
public class RecipeScrape {
    /**
     *
     *
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

            for (Element titleItem : recipePage.select("div.recipe-title")) {
                    name = titleItem.select("h2").text();
            }

            for (Element titleItem : recipePage.select("div.post-meta.time p")) {
                    titleList.add(titleItem.select("span").text());
            }
        } catch (Exception ex){
            log.error(ex);
        }

        if (titleList.size() < 4) {

        } else {

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
        }
        return null;
    }

    /**
     * This class scrapes the ingredients and enters them into a list.
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
     *
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
     *
     * @return
     */
    public Categories scrapeAllCategories() {
        String url = "https://damndelicious.net/recipe-index/";

        Categories categories = new Categories();
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
                    Category category = scrapeByCategoryName(urlToEachCategory, 100);

                    categoriesList.add(category);
                }
            }
        } catch (Exception ex) {
            log.error(ex);
        }
        categories.setCategoriesItems(categoriesList);

        return categories;
    }

    /**
     * @param
     * @return
     */
    public Category scrapeByCategoryName(String url, int numberOfPagesToScrape) {

        Category category = new Category();
        ArrayList<Recipe> recipeList = new ArrayList<>();
        String categoryName = "";

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
                counter = 1000;
            }
            counter++;
        }

        log.info(categoryName + " - Finished Scraping");
        category.setName(categoryName);
        category.setRecipes(recipeList);
        return category;
    }
}
