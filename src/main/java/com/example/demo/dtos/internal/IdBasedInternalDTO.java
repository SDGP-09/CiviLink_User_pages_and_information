package com.example.demo.dtos.internal;

public class IdBasedInternalDTO {

    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IdBasedInternalDTO(Long id) {
        this.id = id;
    }
}
