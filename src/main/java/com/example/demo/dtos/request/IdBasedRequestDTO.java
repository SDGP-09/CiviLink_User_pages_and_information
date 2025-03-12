package com.example.demo.dtos.request;

public class IdBasedRequestDTO {

    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IdBasedRequestDTO(Long id) {
        this.id = id;
    }
}
