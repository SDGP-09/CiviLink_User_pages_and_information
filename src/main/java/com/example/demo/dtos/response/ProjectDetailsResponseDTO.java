package com.example.demo.dtos.response;

import com.example.demo.types.ProjectCard;

public class ProjectDetailsResponseDTO {

    private ProjectCard[] projects;


    public ProjectCard[] getProjects() {
        return projects;
    }

    public void setProjects(ProjectCard[] projects) {
        this.projects = projects;
    }

    public ProjectDetailsResponseDTO(ProjectCard[] projects) {
        this.projects = projects;
    }

    public ProjectDetailsResponseDTO(){}
}
