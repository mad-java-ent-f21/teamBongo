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


@Path("/recipes")
public class Recipes {
    // The Java method will process HTTP GET requests
    @GET
    @Produces("text/plain")
    public Response getRecipe() throws JsonProcessingException {
        //Build JSON object to return --SOURCE https://docs.oracle.com/javaee/7/api/javax/json/JsonObjectBuilder.html --
        //not used, but good reference --SOURCE https://mkyong.com/webservices/jax-rs/json-example-with-jersey-jackson/
        //Convert Java object to JSON using Jackson Library --SOURCE https://www.youtube.com/watch?v=ri7K7nc9VSo&t=514s
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<String> ingredients = new ArrayList<String>();
        ingredients.add("chicken");
        ingredients.add("cream of mushroom");
        ingredients.add("green peas");
        ingredients.add("carrots");
        ingredients.add("pie crust");

        List<String> steps = new ArrayList<String>();
        steps.add("open all ingredients");
        steps.add("add all ingredients together");
        steps.add("put in oven");
        steps.add("wait for the smoke alarm to go off");
        steps.add("profit");

        Recipe recipe = new Recipe();
        recipe.setId(1);
        recipe.setName("Chicken Pot Pie");
        recipe.setServingSize("1 cup");
        recipe.setTime(120.00);
        recipe.setIngredients(ingredients);
        recipe.setSteps(steps);

        String output = objectMapper.writeValueAsString(recipe);

        return Response.status(200).entity(output).build();
    }
}