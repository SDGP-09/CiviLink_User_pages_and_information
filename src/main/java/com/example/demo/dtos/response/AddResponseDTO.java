package com.example.demo.dtos.response;

import com.example.demo.enums.Field;
import com.google.cloud.storage.Blob;

public class AddResponseDTO {
    private Long id;
    private Long ownerId;
    private String title;
    private String description;
    private Field field;
    private Blob[] images;
    private String fullDescription;
    private boolean show;
    private Integer perHour;
    private Integer perDay;
    private Integer perWeek;
    private Integer perMonth;
    private Integer perYear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Blob[] getImages() {
        return images;
    }

    public void setImages(Blob[] images) {
        this.images = images;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public Integer getPerHour() {
        return perHour;
    }

    public void setPerHour(Integer perHour) {
        this.perHour = perHour;
    }

    public Integer getPerDay() {
        return perDay;
    }

    public void setPerDay(Integer perDay) {
        this.perDay = perDay;
    }

    public Integer getPerWeek() {
        return perWeek;
    }

    public void setPerWeek(Integer perWeek) {
        this.perWeek = perWeek;
    }

    public Integer getPerMonth() {
        return perMonth;
    }

    public void setPerMonth(Integer perMonth) {
        this.perMonth = perMonth;
    }

    public Integer getPerYear() {
        return perYear;
    }

    public void setPerYear(Integer perYear) {
        this.perYear = perYear;
    }

    public AddResponseDTO(
            Long id,
            Long ownerId,
            String title,
            String description,
            Field field,
            Blob[] images,
            String fullDescription,
            boolean show,
            Integer perHour,
            Integer perDay,
            Integer perWeek,
            Integer perMonth,
            Integer perYear
    ) {
        this.id = id;
        this.ownerId = ownerId;
        this.title = title;
        this.description = description;
        this.field = field;
        this.images = images;
        this.fullDescription = fullDescription;
        this.show = show;
        this.perHour = perHour;
        this.perDay = perDay;
        this.perWeek = perWeek;
        this.perMonth = perMonth;
        this.perYear = perYear;
    }

    public AddResponseDTO(){}
}
