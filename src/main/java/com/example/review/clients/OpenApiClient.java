package com.example.review.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenApiClient {
    private static final String API_BASE_URL = "https://openlibrary.org/api/books";

    public String searchBooks(String query) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_BASE_URL + "?bibkeys=" + query + "&format=json&jscmd=data";
        return restTemplate.getForObject(url, String.class);
    }
}
