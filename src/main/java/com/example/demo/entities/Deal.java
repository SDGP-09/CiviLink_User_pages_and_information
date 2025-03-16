package com.example.demo.entities;


import com.example.demo.enums.DealField;
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
    private DealField fields;

    @OneToMany(mappedBy = "deal")
    private List<DealImage> images;

    private String fullDescription;

    private boolean visible;

    private int perHour;

    private int perDay;

    private int perWeek;

    private int perMonth;

    private int perYear;

    private int price;

    @ManyToOne
    @JoinColumn(
            name = "Contractor_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_deal_contractor")
    )
    private Contractor contractor;



    public Deal() {

    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
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

    public DealField getFields() {
        return fields;
    }

    public void setFields(DealField fields) {
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean show) {
        this.visible = show;
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


    public Deal(String title, String descriptions, DealField fields, String fullDescription, boolean visible, int perHour, int perDay, int perWeek, int perMonth, int perYear, int price, Contractor contractor) {
        this.title = title;
        this.descriptions = descriptions;
        this.fields = fields;
        this.fullDescription = fullDescription;
        this.visible = visible;
        this.perHour = perHour;
        this.perDay = perDay;
        this.perWeek = perWeek;
        this.perMonth = perMonth;
        this.perYear = perYear;
        this.price = price;
        this.contractor = contractor;
    }

    public Deal(
            String title,
            String descriptions,
            DealField fields,
            List<DealImage> images,
            String fullDescription,
            boolean visible,
            int perHour,
            int perDay,
            int perWeek,
            int perMonth,
            int perYear,
            int price,
            Contractor contractor
    ) {
        this.title = title;
        this.descriptions = descriptions;
        this.fields = fields;
        this.images = images;
        this.fullDescription = fullDescription;
        this.visible = visible;
        this.perHour = perHour;
        this.perDay = perDay;
        this.perWeek = perWeek;
        this.perMonth = perMonth;
        this.perYear = perYear;
        this.price = price;
        this.contractor = contractor;
    }
}