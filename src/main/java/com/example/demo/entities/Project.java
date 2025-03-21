package com.example.demo.entities;

import com.example.demo.enums.ProjectStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "Contractor_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_project_contractor")
    )
    private Contractor contractor;
    private String name;
    private String description;
    private String startDate;
    private String estimatedCompletion;

    private boolean visible;

    @OneToMany(mappedBy = "project")
    private List<ProjectImage> images;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEstimatedCompletion() {
        return estimatedCompletion;
    }

    public void setEstimatedCompletion(String estimatedCompletion) {
        this.estimatedCompletion = estimatedCompletion;
    }

    public List<ProjectImage> getImages() {
        return images;
    }

    public void setImages(List<ProjectImage> images) {
        this.images = images;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visibility) {
        this.visible = visibility;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Project(
            Long id,
            Contractor contractor,
            String name,
            String description,
            String startDate,
            String estimatedCompletion,
            List<ProjectImage> images,
            ProjectStatus status,
            boolean visible
    ) {
        this.id = id;
        this.contractor = contractor;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.estimatedCompletion = estimatedCompletion;
        this.images = images;
        this.status = status;
        this.visible = visible;
    }


    public Project(){}
}
