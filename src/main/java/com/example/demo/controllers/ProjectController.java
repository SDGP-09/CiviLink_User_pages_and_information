package com.example.demo.controllers;

import com.example.demo.entities.Project;
import com.example.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Create a new project
    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.addProject(project));
    }

    // Get all projects
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    // Get projects by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Project>> getProjectsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(projectService.getProjectsByUser(userId));
    }

    // Get a project by ID
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable String id) {
        Optional<Project> project = projectService.getProjectById(id);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a project
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable String id, @RequestBody Project project) {
        return ResponseEntity.ok(projectService.updateProject(id, project));
    }

    // Delete a project by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable String id) {
        Optional<Project> existingProject = projectService.getProjectById(id);
        if (existingProject.isPresent()) {
            projectService.deleteProject(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete all projects
    @DeleteMapping
    public ResponseEntity<Void> deleteAllProjects() {
        projectService.deleteAllProjects();
        return ResponseEntity.noContent().build();
    }
}