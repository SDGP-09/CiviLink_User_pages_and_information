package com.example.demo.services;

import com.example.demo.entities.Project;
import com.example.demo.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getProjectsByUser(String userId) {
        return projectRepository.findByUserId(userId);
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(String projectId) {
        projectRepository.deleteById(projectId);
    }
}

