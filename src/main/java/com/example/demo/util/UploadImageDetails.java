package com.example.demo.util;

public class UploadImageDetails {
    private String Url;
    private String id;

    public UploadImageDetails(String url, String id) {
        Url = url;
        this.id = id;
    }

    public UploadImageDetails() {
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
