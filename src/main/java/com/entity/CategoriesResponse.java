package com.entity;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;

import com.entity.categories.Categories;
import com.fasterxml.jackson.core.JsonProcessingException;
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

        //Create Categories object
        Categories categories = new Categories();

        Category category1 = new Category();
        category1.setName("Appetizer");
        Category category2 = new Category();
        category2.setName("Breakfast");
        Category category3 = new Category();
        category3.setName("Dessert");

        List<Category> categoriesList = new ArrayList<>();
        categoriesList.add(category1);
        categoriesList.add(category2);
        categoriesList.add(category3);

        categories.setCategoriesItems(categoriesList);

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
    public Response getCategoriesByCategory(@PathParam("category_param")String categoryParam) {
        //Initialize the output variable
        String output = "Category: " + categoryParam;

        //Create an object mapper so that we can make a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);


        return Response.status(200).entity(output).build();
    }
}
