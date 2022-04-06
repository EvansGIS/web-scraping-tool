package com.david;

import com.david.datalayer.NicheDataExcelService;
import com.david.drivers.DriverFactory;
import com.david.pages.GoogleSearchResults;
import com.david.pages.Page;
import com.david.resources.Website;
import com.david.services.MozApiService;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public class ScraperProgram {

    public static WebDriver WEBDRIVER;
    public static NicheDataExcelService REPOSITORY;
    public static MozApiService MOZ_API_SERVICE;
    public static void main(String[] args) {

        var excelFileNAme = "";
        REPOSITORY = new NicheDataExcelService(excelFileNAme);
        WEBDRIVER = DriverFactory.GetWebDriver();
        MOZ_API_SERVICE = MozApiService.getInstance();
        var googleSearchResultsPage = new GoogleSearchResults(WEBDRIVER);

        var inputs = REPOSITORY.getKeywordInputs();
        inputs.forEach(query -> {
            googleSearchResultsPage.runSearch(query);
            var websiteResults = googleSearchResultsPage.getWebsites();
            processWebsiteResults(websiteResults);
        });

    }

    public static void processWebsiteResults(List<Website> websites){
        websites.forEach(website -> {
            WEBDRIVER.get(website.url);
            var page = new Page(WEBDRIVER);
            var processedSite = page.getWebsite();

            try {
                processedSite.stats = MOZ_API_SERVICE.getWebsiteStats(website.url);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            REPOSITORY.addWebsite(processedSite);
        });
    }
}
