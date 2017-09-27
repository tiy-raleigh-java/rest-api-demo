package com.theironyard.restapidemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repo {

    private String name;
    private String description;
    @JsonProperty("html_url")
    private String htmlUrl;
    private boolean isFork;
    private boolean isPrivate;

    public Repo(String name, String description, String httpUrl, boolean isFork, boolean isPrivate) {
        this.name = name;
        this.description = description;
        this.htmlUrl = httpUrl;
        this.isFork = isFork;
        this.isPrivate = isPrivate;
    }

    public Repo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String url) {
        this.htmlUrl = url;
    }

    public boolean isFork() {
        return isFork;
    }

    public void setFork(boolean fork) {
        isFork = fork;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
}
