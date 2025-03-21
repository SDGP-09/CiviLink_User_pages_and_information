package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class ProjectImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @ManyToOne
    @JoinColumn(
            name = "Project_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_projectImage_project")
    )
    private Project project;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public ProjectImage(Long id, String image, Project project) {
        this.id = id;
        this.image = image;
        this.project = project;
    }


    public ProjectImage(){}

}
