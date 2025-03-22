package com.example.demo.dtos.internal;

public class ProjectIdBasedInternalDTO {

    private Long addId;
    private Long contractorId;

    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    public Long getOwnerId() {
        return contractorId;
    }

    public void setOwnerId(Long ownerId) {
        this.contractorId = ownerId;
    }

    public ProjectIdBasedInternalDTO(Long addId, Long ownerId) {
        this.addId = addId;
        this.contractorId = ownerId;
    }


    public ProjectIdBasedInternalDTO(){}

}
