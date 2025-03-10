package com.example.demo.entities;


import com.example.demo.enums.Field;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String descriptions;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Field fields;

    @OneToMany(mappedBy = "deal")
    private List<DealImage> images;

    private String fullDescription;

    private boolean show;

    private int perHour;

    private int perDay;

    private int perWeek;

    private int perMonth;

    private int perYear;


    public Deal() {

    }

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

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Field getFields() {
        return fields;
    }

    public void setFields(Field fields) {
        this.fields = fields;
    }

    public List<DealImage> getImages() {
        return images;
    }

    public void setImages(List<DealImage> images) {
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

    public int getPerHour() {
        return perHour;
    }

    public void setPerHour(int perHour) {
        this.perHour = perHour;
    }

    public int getPerDay() {
        return perDay;
    }

    public void setPerDay(int perDay) {
        this.perDay = perDay;
    }

    public int getPerWeek() {
        return perWeek;
    }

    public void setPerWeek(int perWeek) {
        this.perWeek = perWeek;
    }

    public int getPerMonth() {
        return perMonth;
    }

    public void setPerMonth(int perMonth) {
        this.perMonth = perMonth;
    }

    public int getPerYear() {
        return perYear;
    }

    public void setPerYear(int perYear) {
        this.perYear = perYear;
    }

    public Deal(
            String title,
            String descriptions,
            Field fields,
            List<DealImage> images,
            String fullDescription,
            boolean show,
            int perHour,
            int perDay,
            int perWeek,
            int perMonth,
            int perYear
    ) {
        this.title = title;
        this.descriptions = descriptions;
        this.fields = fields;
        this.images = images;
        this.fullDescription = fullDescription;
        this.show = show;
        this.perHour = perHour;
        this.perDay = perDay;
        this.perWeek = perWeek;
        this.perMonth = perMonth;
        this.perYear = perYear;
    }
}