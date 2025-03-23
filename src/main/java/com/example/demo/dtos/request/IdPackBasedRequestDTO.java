package com.example.demo.dtos.request;

public class IdPackBasedRequestDTO {

    private Long[] ids;

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

    public IdPackBasedRequestDTO(Long[] ids) {
        this.ids = ids;
    }

    public IdPackBasedRequestDTO(){}


}
