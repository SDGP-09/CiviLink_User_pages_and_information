package com.example.demo.types;

import com.example.demo.enums.ProjectStatus;

public class ProjectCard {
    private Long id;
    private String contractorId;
    private String description;
    private String startDate;
    private String completion;
    private boolean visible;
    private String[] images;
    private ProjectStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractorId() {
        return contractorId;
    }

    public void setContractorId(String contractorId) {
        this.contractorId = contractorId;
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

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public ProjectCard(
            Long id,
            String contractorId,
            String description,
            String startDate,
            String completion,
            boolean visible,
            String[] images,
            ProjectStatus status
    ) {
        this.id = id;
        this.contractorId = contractorId;
        this.description = description;
        this.startDate = startDate;
        this.completion = completion;
        this.visible = visible;
        this.images = images;
        this.status = status;
    }

    public ProjectCard(){}
}
