package com.sample.movie_practice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    @Value("${tmdb.api.key}")
    private String apiKey;

    @GetMapping("/api/movies/popular")
    public ResponseEntity<String> getPopularMovies() {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey + "&language=ko-KR"; // 여기에 발급받은 내 api key 넣기
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
}
