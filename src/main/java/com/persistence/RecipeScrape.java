package com.persistence;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Log4j2
public class RecipeScrape {

    public String scrapeRecipe() {

        String url = "https://damndelicious.net/2020/09/19/pumpkin-chocolate-chip-pancakes/print/";

        try {
            final Document recipePage = Jsoup.connect(url).get();

            return recipePage.outerHtml();
        }
        catch (Exception ex) {
            log.error(ex);
            return "Error Occurred. See Logs";
        }
    }
}
