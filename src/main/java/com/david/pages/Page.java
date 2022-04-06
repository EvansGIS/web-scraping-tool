package com.david.pages;

import com.david.resources.Website;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class Page {
    public WebDriver webdriver;
    public Page(WebDriver webDriver){
        this.webdriver = webDriver;
    }
    public String getTitle(){
        return this.webdriver.getTitle();
    }

    public boolean isPageRunningAdsense(){
        var source = this.webdriver.getPageSource();
        if(source.toLowerCase(Locale.ROOT).indexOf("pub-")>0){
            return true;
        }
        return false;
    }

    public Website getWebsite(){
        var website = new Website();
        website.name = this.getTitle();
        website.runsAdsense = this.isPageRunningAdsense();
        return website;
    }
}
