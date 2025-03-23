package com.example.demo.entities;


import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    private String imageUrl;
    private String imageId;


    public Image(Long id, String imageUrl, String imageId) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
    }

    public Image() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}
