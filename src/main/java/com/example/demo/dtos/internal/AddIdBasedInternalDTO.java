package com.example.demo.dtos.internal;

public class AddIdBasedInternalDTO {

    private Long addId;
    private Long ownerId;

    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }


    public AddIdBasedInternalDTO(Long addId, Long ownerId) {
        this.addId = addId;
        this.ownerId = ownerId;
    }

    public AddIdBasedInternalDTO(){}
}
