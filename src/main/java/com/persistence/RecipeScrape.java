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
     * This class scrapes the ingredients and enters them into a list.
     * @return ingredients
     */

    public ArrayList<String> scrapeIngredients() {

        String url = "https://damndelicious.net/2020/09/19/pumpkin-chocolate-chip-pancakes/print/";

        ArrayList<String> ingredientList = new ArrayList();

        int counter = 0;

        try {
            final Document recipePage = Jsoup.connect(url).get();

            for (Element item : recipePage.select("div.ingredients ul li")) {
                if (item.text().equals("")) {
                    continue;
                }
                else {
                    String ingredient = item.select("li:nth-of-type(1)").text();

                    ingredientList.add(item.text());
                }
            }
        }
        catch (Exception ex) {
            log.error(ex);
        }

        return ingredientList;
    }

    public Categories scrapeAllCategories() {
        String url = "https://damndelicious.net/recipe-index/";

        Categories categories = new Categories();
        ArrayList<Category> categoriesList = new ArrayList();

        try {
            final Document categoryIndexPage = Jsoup.connect(url).get();

            for (Element item : categoryIndexPage.select("div.archive-post")) {
                if (item.text().equals("")) {
                    continue;
                } else {
                    
                    String formattedText = item.text().replace(" ", "-");
                    Category category = scrapeByCategoryName(formattedText);
                    categoriesList.add(category);
                }
            }
        } catch (Exception ex) {
            log.error(ex);
        }

        categories.setCategoriesItems(categoriesList);

        return categories;
    }

    public Category scrapeByCategoryName(String categoryNameParam) {
        String url = "https://damndelicious.net/category/" + categoryNameParam + "/";

        Category category = new Category();
        ArrayList<Recipe> recipeList = new ArrayList<>();

        try {
            final Document categoryPage = Jsoup.connect(url).get();

            for (Element item : categoryPage.select("div.archive-post h4.title")) {
                if (item.text().equals("")) {
                    continue;
                } else {
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
