package com.example.demo.dtos.request;

import com.example.demo.enums.Field;
import org.springframework.web.multipart.MultipartFile;

public class UpdateAddRequestDTO {

    private Long id;
    private String title;
    private String description;
    private Field field;
    private String[] deletedImages;
    private MultipartFile[] images;
    private String fullDescription;
    private boolean show;
    private Integer perHour;
    private Integer perDay;
    private Integer perWeek;
    private Integer perMonth;
    private Integer perYear;
    private Integer price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String[] getDeletedImages() {
        return deletedImages;
    }

    public void setDeletedImages(String[] deletedImages) {
        this.deletedImages = deletedImages;
    }

    public MultipartFile[] getImages() {
        return images;
    }

    public void setImages(MultipartFile[] images) {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public UpdateAddRequestDTO(
            Long id,
            String title,
            String description,
            Field field,
            String[] deletedImages,
            MultipartFile[] images,
            String fullDescription,
            boolean show,
            Integer perHour,
            Integer perDay,
            Integer perWeek,
            Integer perMonth,
            Integer perYear,
            Integer price
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.field = field;
        this.deletedImages = deletedImages;
        this.images = images;
        this.fullDescription = fullDescription;
        this.show = show;
        this.perHour = perHour;
        this.perDay = perDay;
        this.perWeek = perWeek;
        this.perMonth = perMonth;
        this.perYear = perYear;
        this.price = price;
    }


    public UpdateAddRequestDTO(){}


}
