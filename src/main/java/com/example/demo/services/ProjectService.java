package com.example.demo.services;

import com.example.demo.entities.Project;
import com.example.demo.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Create a new project
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    // Get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Get projects by user ID
    public List<Project> getProjectsByUser(String userId) {
        return projectRepository.findByUserId(userId);
    }

    // Get a single project by ID
    public Optional<Project> getProjectById(String projectId) {
        return projectRepository.findById(projectId);
    }

    // Update an existing project
    public Project updateProject(String projectId, Project updatedProject) {
        updatedProject.setId(projectId);
        return projectRepository.save(updatedProject);
    }

    // Delete a project by ID
    public void deleteProject(String projectId) {
        projectRepository.deleteById(projectId);
    }

    // Delete all projects
    public void deleteAllProjects() {
        projectRepository.deleteAll();
    }
}