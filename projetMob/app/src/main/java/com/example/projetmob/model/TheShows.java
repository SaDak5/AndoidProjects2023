package com.example.projetmob.model;
public class TheShows {
    public int id;
    public String url;
    public String name;
    public String language;
    public String summary;

    // Constructor with parameters
    public TheShows(int id, String url, String name, String language,String summary) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.language = language;
        this.summary = summary;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }
    public String getSummary() {
        return summary;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    @Override
    public String toString() {
        return "TheShow{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
