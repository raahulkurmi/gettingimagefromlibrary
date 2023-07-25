package com.example.api;

public class layout {
    String title;
   String body;

    public layout(String title,String posts){
        this.title=title;
        this.body=body;


    }

    public String getTitles() {
        return title;
    }

    public void setTitles(String titles) {
        this.title = titles;
    }

    public String getPosts() {
        return body;
    }

    public void setPosts(String posts) {
        this.body = posts;
    }
}