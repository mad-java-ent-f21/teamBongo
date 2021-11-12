package com.persistence;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

@Log4j2
public class RecipeScrape {

    /**
     * This class scrapes the ingredients and enters them into a list.
     * @return ingredients
     */

    public ArrayList<String> scrapeIngredients() {

        String url = "https://damndelicious.net/2021/10/21/pumpkin-donut-holes/print/";

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
}
