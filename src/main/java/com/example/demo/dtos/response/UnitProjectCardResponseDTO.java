package com.example.demo.dtos.response;

import com.example.demo.enums.ProjectStatus;

public class UnitProjectCardResponseDTO {
    private Long id;
    private Long contractorId;
    private String description;
    private String startDate;
    private String completion;
    private String[] images;
    private ProjectStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractorId() {
        return contractorId;
    }

    public void setContractorId(Long contractorId) {
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

    public UnitProjectCardResponseDTO(
            Long id,
            Long contractorId,
            String description,
            String startDate,
            String completion,
            String[] images,
            ProjectStatus status
    ) {
        this.id = id;
        this.contractorId = contractorId;
        this.description = description;
        this.startDate = startDate;
        this.completion = completion;
        this.images = images;
        this.status = status;
    }
}
