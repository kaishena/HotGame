package com.example.hotgame.entity;

public class Game {
    private String name;
    private String introduction;
    private String imageSource;
    private String downloadUrl;
    public Game(String name,String introduction,String imageSource,String downloadUrl)
    {
        this.name=name;
        this.introduction=introduction;
        this.imageSource=imageSource;
        this.downloadUrl=downloadUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getName() {
        return name;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public void setName(String name) {
        this.name = name;
    }
}
