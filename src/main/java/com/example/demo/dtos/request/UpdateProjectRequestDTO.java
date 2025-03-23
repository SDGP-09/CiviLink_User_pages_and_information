package com.example.demo.dtos.request;

import com.example.demo.enums.ProjectStatus;
import org.springframework.web.multipart.MultipartFile;

public class UpdateProjectRequestDTO {

    private Long id;
    private String name;
    private String description;
    private String startDate;
    private String estimatedCompletion;
    private boolean visible;
    private String[] deletedImages;
    private ProjectStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String[] getDeletedImages() {
        return deletedImages;
    }

    public void setDeletedImages(String[] deletedImages) {
        this.deletedImages = deletedImages;
    }


    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public UpdateProjectRequestDTO(Long id,
                                   String name,
                                   String description,
                                   String startDate,
                                   String estimatedCompletion,
                                   boolean visible,
                                   String[] deletedImages,
                                   ProjectStatus status
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.estimatedCompletion = estimatedCompletion;
        this.visible = visible;
        this.deletedImages = deletedImages;
        this.status = status;
    }

    public UpdateProjectRequestDTO(){}
}
