package com.example.demo.dtos;

public class ProjectDTO {
    private String name;
    private String status;
    private Integer progress;

    public ProjectDTO(String name, String status, Integer progress) {
        this.name = name;
        this.status = status;
        this.progress = progress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
