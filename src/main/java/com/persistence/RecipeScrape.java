package com.persistence;

import com.entity.categories.Categories;
import com.entity.categories.Category;
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
     *
     *
     */
    public ArrayList<String> scrapeTitleInfo() {

        String url = "https://damndelicious.net/2021/10/21/pumpkin-donut-holes/print/";

        String name = "";
        ArrayList<String> titleList = new ArrayList();
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

        titleList.add(0, name);

        return titleList;
    }

    /**
     * This class scrapes the ingredients and enters them into a list.
     * @return ingredients
     */

    public ArrayList<String> scrapeIngredients() {

        String url = "https://damndelicious.net/2021/10/21/pumpkin-donut-holes/print/";

        ArrayList<String> ingredientList = new ArrayList();

        try {
            final Document recipePage = Jsoup.connect(url).get();

            for (Element item : recipePage.select("div.ingredients ul li")) {
                if (item.text().equals("")) {
                    continue;
                }
                else {
                    //String ingredient = item.select("li:nth-of-type(1)").text();

                    ingredientList.add(item.text());
                }
            }
        }
        catch (Exception ex) {
            log.error(ex);
        }

        return ingredientList;
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

                    //Calls the method that crapes the index of the individual Catergories.
                    Category category = scrapeByCategoryName(urlToEachCategory, catergoryName);

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
     *
     * @param categoryNameParam
     * @return
     */
    public Category scrapeByCategoryName(String urlToCatergory, String categoryNameParam) {
        String url = urlToCatergory;

        Category category = new Category();
        ArrayList<Recipe> recipeList = new ArrayList<>();

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

                    log.info("\n\nName: " + recipeName + " ---- url: " + urlToEachRecipe);

                    Recipe recipe = new Recipe();
                    recipe.setName(item.text());
                    recipeList.add(recipe);
                }
            }
        } catch (Exception ex) {
            log.error(ex);
        }

        category.setName(categoryNameParam);
        category.setRecipes(recipeList);
        return category;
    }
}
