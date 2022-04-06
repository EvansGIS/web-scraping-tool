package com.david.services;

import com.david.resources.WebsiteStats;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public final class MozApiService {

    private static MozApiService INSTANCE;
    private HttpClient httpClient;
    private String apiKey; // this will likely be needed in the GET request

    public static MozApiService getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MozApiService();
            INSTANCE.httpClient = HttpClient.newHttpClient();
        }
        return INSTANCE;
    }


    public WebsiteStats getWebsiteStats(String website) throws IOException, InterruptedException {
        // call Moz API using the http Client
        String url = "";
        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        // use the client to send the request
        HttpResponse<String> response = null;

        response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        WebsiteStats result = new Gson().fromJson(response.body(), new TypeToken<WebsiteStats>() {}.getType());
        return result;
    }
}
