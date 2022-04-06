package com.david.pages;

import com.david.resources.Website;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResults extends Page {


    public GoogleSearchResults(WebDriver webDriver) {
        super(webDriver);
    }

    public void runSearch(String keywords){
        String url = "https://google.com/search?q="+keywords;
        webdriver.get(url);
    }

    public List<Website> getWebsites(){
        var data = new ArrayList<Website>();
        // TODO: scrape website links using webdriver and populate data array.
        return data;
    }
}
