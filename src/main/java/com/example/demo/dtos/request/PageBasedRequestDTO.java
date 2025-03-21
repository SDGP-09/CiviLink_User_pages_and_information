package com.example.demo.dtos.request;

public class PageBasedRequestDTO {
    private int pageNumber;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public PageBasedRequestDTO(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public PageBasedRequestDTO(){}
}
