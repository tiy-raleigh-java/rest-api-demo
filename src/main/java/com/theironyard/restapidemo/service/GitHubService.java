package com.theironyard.restapidemo.service;


import com.theironyard.restapidemo.entity.Repo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GitHubService {

    public static final String API_ADDRESS = "https://api.github.com";
    private final String apiToken;

    public GitHubService(@Value("${API_KEY}") String apiToken) {
        this.apiToken = apiToken;
    }

    public List<Repo> listRepos(String search){
        RestTemplate restTemplate = new RestTemplate();
        List<Repo> repos = Arrays.asList(
                restTemplate.getForObject(API_ADDRESS + "/user/repos?affiliation=owner&access_token=" + this.apiToken, Repo[].class)
        );

        return repos.stream()
                // filters to the search term
                .filter(repo -> search == null || repo.getName().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Repo saveRepo(Repo repo) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(API_ADDRESS + "/user/repos?access_token=" + this.apiToken, repo, Repo.class);
    }
}
