package com.entity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.*;
import com.util.RecipeGenerator;

import com.entity.category.Category;
import com.entity.recipe.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Path("/categories")
public class Categories {
    @GET
    @Produces("text/plain")
    public Response getCategory() {

        //Instantiate a RecipeGenerator for testing
        RecipeGenerator recipeGenerator = new RecipeGenerator();

        //Create an object mapper so that we can make a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Recipe> recipes = recipeGenerator.createRecipes();

        Category category = new Category();
        category.setName("Appetizers");
        category.setRecipes(recipes);

        return Response.status(200).entity("OUTPUT GOES HERE").build();
    }
}
