package com.example.demo.dtos.request;

public class AddIdBasedRequestDTO {

    private Long addId;

    public Long getAddId() {
        return addId;
    }

    public void setAddId(Long addId) {
        this.addId = addId;
    }

    public AddIdBasedRequestDTO(Long addId) {
        this.addId = addId;
    }

    public AddIdBasedRequestDTO(){}

}
