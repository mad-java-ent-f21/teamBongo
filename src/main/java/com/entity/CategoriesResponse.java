package com.entity;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;

import com.entity.categories.Categories;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.persistence.RecipeScrape;
import com.util.RecipeGenerator;

import com.entity.categories.Category;
import com.entity.recipe.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Path("/categories")
public class CategoriesResponse {

    @GET
    @Produces("text/plain")
    public Response getCategories() throws JsonProcessingException {

        //Instantiate a RecipeScape object
        RecipeScrape scraper = new RecipeScrape();

        //Create Categories object
        Categories categories = scraper.scrapeAllCategories();

        //Create an object mapper so that we can make a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Initialize the output variable
        String output = objectMapper.writeValueAsString(categories);

        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("{category_param}")
    @Produces("text/plain")
    public Response getCategoriesByCategory(@PathParam("category_param")String categoryParam) throws JsonProcessingException {
        //Instantiate a RecipeScrape object
        RecipeScrape scraper = new RecipeScrape();

        //Create Categories object
        Category category = scraper.scrapeByCategoryName("https://damndelicious.net/category/" + categoryParam + "/", 1);

        //Create an object mapper so that we can make a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Initialize the output variable
        String output = objectMapper.writeValueAsString(category);

        return Response.status(200).entity(output).build();
    }
}
