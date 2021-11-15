package com.entity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.*;
import com.entity.recipe.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.persistence.RecipeScrape;
import com.util.RecipeGenerator;


@Path("categories/recipes")
public class RecipesResponse {
    /**
     * The Java method will return a response from an HTTP GET request set to the /recipes path
     * @return Response object
     * @throws JsonProcessingException
     **/

    @GET
    @Path("{recipe_name}")
    @Produces("text/plain")
    public Response getRecipe(@PathParam("recipe_name")String recipeName) throws JsonProcessingException {
        //Build JSON object to return --SOURCE https://docs.oracle.com/javaee/7/api/javax/json/JsonObjectBuilder.html --
        //not used, but good reference --SOURCE https://mkyong.com/webservices/jax-rs/json-example-with-jersey-jackson/
        //Convert Java object to JSON using Jackson Library --SOURCE https://www.youtube.com/watch?v=ri7K7nc9VSo&t=514s

        //Instantiate a RecipeScape object
        RecipeScrape scraper = new RecipeScrape();

        //Create an object mapper so that we can make a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create a Recipe object and set it to a returned recipe based off the method param
        Recipe recipeToOutput = scraper.scrapeRecipe("https://damndelicious.net/" + recipeName + "/");


        //Initialize output variable
        String output = objectMapper.writeValueAsString(recipeToOutput);

        return Response.status(200).entity(output).build();
    }
}