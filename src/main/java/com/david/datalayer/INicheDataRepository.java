package com.david.datalayer;

import com.david.resources.Website;
import com.david.resources.WebsiteSearch;

import java.util.List;

public interface INicheDataRepository {

    public void addWebsite(Website website);
    public List<Website> getWebsites(WebsiteSearch search);
}
