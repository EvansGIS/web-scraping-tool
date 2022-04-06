package com.david.datalayer;

import com.david.resources.Website;
import com.david.resources.WebsiteSearch;

import java.util.ArrayList;
import java.util.List;

public class NicheDataExcelService {

    //TODO: Connect to excel workbook in this class

    public NicheDataExcelService(String fileName){
        // open up an excel workbook
    }

    public List<String> getKeywordInputs(){
        var data = new ArrayList<String>();
        // get data from excel
        return data;
    }

    public void addWebsite(Website website){
        // Write data to excel
        // in here is where you will want to have logic that
        // handles de-duping and data management.
    }

    public List<Website> getWebsites(WebsiteSearch search){
        var data = new ArrayList<Website>();
        // get data from excel
        return data;
    }
}
