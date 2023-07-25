package com.example.newspaperapp;

import java.util.ArrayList;

public class mainnews {
    private String stauts;
    private String totalnews;
    private ArrayList<modelclass> article;

    public mainnews(String stauts, String totalnews, ArrayList<modelclass> article) {
        this.stauts = stauts;
        this.totalnews = totalnews;
        this.article = article;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    public String getTotalnews() {
        return totalnews;
    }

    public void setTotalnews(String totalnews) {
        this.totalnews = totalnews;
    }

    public ArrayList<modelclass> getArticle() {
        return article;
    }

    public void setArticle(ArrayList<modelclass> article) {
        this.article = article;
    }
}
