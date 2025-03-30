package com.example.demo.dtos.internal;

public class AddIdBasedInternalDTO {

    private Long addId;
    private String ownerId;

    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }


    public AddIdBasedInternalDTO(Long addId, String ownerId) {
        this.addId = addId;
        this.ownerId = ownerId;
    }

    public AddIdBasedInternalDTO(){}
}
