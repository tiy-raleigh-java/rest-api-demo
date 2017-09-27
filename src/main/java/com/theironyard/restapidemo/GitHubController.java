package com.theironyard.restapidemo;

import com.theironyard.restapidemo.entity.Repo;
import com.theironyard.restapidemo.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GitHubController {

    private final GitHubService gitHubService;

    @Autowired
    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/")
    public String listRepos(Model model, String search){

        List<Repo> repos = gitHubService.listRepos(search);
        model.addAttribute("repos", repos);
        model.addAttribute("search", search);

        return "index";
    }

    @GetMapping("/repoForm")
    public String repoForm(){
        return "repoForm";
    }

    @PostMapping("/saveRepo")
    public String saveRepo(Repo repo){

        Repo savedRepo = gitHubService.saveRepo(repo);

        return "redirect:/";
    }

}
