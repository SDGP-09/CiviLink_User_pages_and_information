package com.example.demo.dtos.request;

public class IdPackBasedRequestDTO {

    private String[] ids;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public IdPackBasedRequestDTO(String[] ids) {
        this.ids = ids;
    }

    public IdPackBasedRequestDTO(){}


}
