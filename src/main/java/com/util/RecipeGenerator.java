package com.util;

import com.entity.recipe.Ingredients;
import com.entity.recipe.Recipe;
import com.entity.recipe.Steps;
import java.util.ArrayList;
import java.util.List;

public class RecipeGenerator {

    public List<Recipe> createRecipes() {
        List<Recipe> recipeList = new ArrayList<>();

        //Create Recipe #1

        //SET Ingredients for Ingredients object
        List<String> ingredients1 = new ArrayList<String>();
        ingredients1.add("2 boneless, skinless chicken breasts");
        ingredients1.add("4 boneless, skinless chicken thighs");
        ingredients1.add("1 cup salsa, homemade or store-bought");
        ingredients1.add("1/2 cup chicken stock");
        ingredients1.add("1 teaspoon chili powder");
        ingredients1.add("1/2 teaspoon ground cumin");
        ingredients1.add("Kosher salt and freshly ground black pepper, to taste");
        ingredients1.add("12 ounces tortilla chips");
        ingredients1.add("3/4 cup pico de gallo, homemade or store-bought");
        ingredients1.add("2 cups shredded cheddar cheese");
        ingredients1.add("1 cup guacamole");
        ingredients1.add("1/2 cup sour cream");
        ingredients1.add("2 tablespoons chopped fresh cilantro leaves");

        Ingredients ingredient1 = new Ingredients();
        ingredient1.setIngredientItems(ingredients1);

        //SET steps for Step object
        List<String> steps1 = new ArrayList<String>();
        steps1.add("Add chicken, salsa, chicken stock, chili powder and cumin to a 6-qt Instant Pot® and gently toss to" +
                " combine; season with salt and pepper, to taste.");
        steps1.add("Select manual setting; adjust pressure to high, and set time for 10 minutes. When finished cooking, " +
                "quick-release pressure according to manufacturer’s directions.");
        steps1.add("Remove chicken from the Instant Pot® and shred using two forks; season with salt and pepper, " +
                "to taste, if needed.");
        steps1.add("Preheat oven to 400 degrees F. Lightly oil a baking sheet or coat with nonstick spray.");
        steps1.add("Place tortilla chips in a single layer onto the prepared baking sheet. Top with 2 cups shredded " +
                "chicken (reserve remaining chicken for later use), pico de gallo and cheese.");
        steps1.add("Place into oven and bake until heated through and the cheeses have melted, about 10-12 minutes.");
        steps1.add("Serve immediately, topped with guacamole, sour cream and cilantro.");

        Steps step1 = new Steps();
        step1.setStepsItems(steps1);

        //SET rest of Recipe Instance Variables
        Recipe recipe1 = new Recipe();
        recipe1.setId(1);
        recipe1.setName("Instant Pot Chicken Nachos");
        recipe1.setCategory("Appetizers");
        recipe1.setYield("8 servings");
        recipe1.setPrepTime(20);
        recipe1.setCookTime(60);
        recipe1.setIngredients(ingredient1);
        recipe1.setSteps(step1);

        //Create Recipe #2
        List<String> ingredients2 = new ArrayList<String>();
        ingredients2.add("8 tablespoons unsalted butter, cubed and divided");
        ingredients2.add("4 cloves garlic, minced");
        ingredients2.add("1 medium shallot, minced");
        ingredients2.add("1 1/2 teaspoons chili powder");
        ingredients2.add("1 teaspoon chili powder");
        ingredients2.add("1/2 teaspoon smoked paprika");
        ingredients2.add("1 pound medium shrimp, peeled and deveined");
        ingredients2.add("Kosher salt and freshly ground black pepper, to taste");
        ingredients2.add("1/3 cup vegetable or chicken stock");
        ingredients2.add("2 tablespoons honey");
        ingredients2.add("1 tablespoon freshly squeezed lime juice");
        ingredients2.add("2 teaspoons lime zest");
        ingredients2.add("2 tablespoons chopped fresh cilantro leaves");

        Ingredients ingredient2 = new Ingredients();
        ingredient2.setIngredientItems(ingredients1);

        List<String> steps2 = new ArrayList<String>();
        steps2.add("Melt 6 tablespoons butter in a large skillet over medium heat.");
        steps2.add("Add garlic and shallot, and cook, stirring frequently, until fragrant, about 1 minute. " +
                "Stir in chili powder and paprika.");
        steps2.add("Add shrimp; season with salt and pepper, to taste. Cook, stirring occasionally, until pink and" +
                " cooked through, about 3-4 minutes.");
        steps2.add("Stir in vegetable or chicken stock, honey, lime juice and lime zest, scraping any browned bits " +
                "from the bottom of the skillet.");
        steps2.add("Remove from heat; stir in cilantro and remaining 2 tablespoons butter until melted.");
        steps2.add("Serve immediately.");

        Steps step2 = new Steps();
        step2.setStepsItems(steps2);

        Recipe recipe2 = new Recipe();
        recipe2.setId(2);
        recipe2.setName("HONEY LIME SHRIMP");
        recipe2.setCategory("Appetizers");
        recipe2.setYield("4 SERVINGS");
        recipe2.setPrepTime(10);
        recipe2.setCookTime(10);
        recipe2.setIngredients(ingredient2);
        recipe2.setSteps(step2);

        //Create Recipe #3
        List<String> ingredients3 = new ArrayList<String>();
        ingredients3.add("1 3/4 cups all-purpose flour");
        ingredients3.add("1/2 teaspoon ground cinnamon");
        ingredients3.add("1/2 teaspoon ground nutmeg");
        ingredients3.add("1/2 teaspoon ground allspice");
        ingredients3.add("1/8 teaspoon ground cloves");
        ingredients3.add("2 teaspoons baking powder");
        ingredients3.add("1/2 teaspoon salt");
        ingredients3.add("3/4 cup pumpkin puree");
        ingredients3.add("1/2 cup milk");
        ingredients3.add("1/2 cup brown sugar");
        ingredients3.add("1/3 cup canola oil");
        ingredients3.add("1 large egg");
        ingredients3.add("1 teaspoon vanilla extract");

        Ingredients ingredient3 = new Ingredients();
        ingredient3.setIngredientItems(ingredients1);

        List<String> steps3 = new ArrayList<String>();
        steps3.add("Preheat oven to 350 degrees F. Lightly oil a mini muffin pan or coat with nonstick spray.");
        steps3.add("In a large bowl, combine flour, cinnamon, nutmeg, allspice, cloves, baking powder and salt.");
        steps3.add("In a large glass measuring cup or another bowl, whisk together pumpkin puree, milk, brown sugar, " +
                "canola oil, egg and vanilla.");
        steps3.add("Pour mixture over dry ingredients and stir using a rubber spatula just until moist.");
        steps3.add("Scoop the batter evenly into the muffin tray.");
        steps3.add("Place into oven and bake for 10-12 minutes, or until a tester inserted in the center comes out clean.");
        steps3.add("To make the cinnamon sugar, combine cinnamon and sugar.");
        steps3.add("When the muffins are done, cool for 2 minutes and dip each muffin into the melted butter and then into the cinnamon-sugar mixture.");
        steps3.add("Let cool on a wire rack.");

        Steps step3 = new Steps();
        step2.setStepsItems(steps3);

        Recipe recipe3 = new Recipe();
        recipe3.setId(3);
        recipe3.setName("PUMPKIN DONUT HOLES");
        recipe2.setCategory("Breakfast");
        recipe3.setYield("24 MINI MUFFINS");
        recipe3.setPrepTime(20);
        recipe3.setCookTime(15);
        recipe3.setIngredients(ingredient3);
        recipe3.setSteps(step3);

        recipeList.add(recipe1);
        recipeList.add(recipe2);
        recipeList.add(recipe3);

        return recipeList;
    }
}
