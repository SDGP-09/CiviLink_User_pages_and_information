package com.example.demo.dtos.internal;

public class ProjectIdBasedInternalDTO {

    private Long addId;
    private String contractorId;

    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    public String getOwnerId() {
        return contractorId;
    }

    public void setOwnerId(String ownerId) {
        this.contractorId = ownerId;
    }

    public ProjectIdBasedInternalDTO(Long addId, String ownerId) {
        this.addId = addId;
        this.contractorId = ownerId;
    }


    public ProjectIdBasedInternalDTO(){}

}
